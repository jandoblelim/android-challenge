package com.jandoblelim.androidchallengejanlim.api;

import android.annotation.SuppressLint;
import android.app.Application;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jandoblelim.androidchallengejanlim.app.AppConfig;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by devskywalker on 03/1/18.
 */

@Module
public class ApiModule {

    private IApiAuthenticator mApiAuthenticator;


    public ApiModule(IApiAuthenticator apiAuthenticator) {
        mApiAuthenticator = apiAuthenticator;
    }

    @Provides
    @Singleton
    public ApiConfig provideApiConfig(Application application) {
        return new ApiConfig(application);
    }

    @Provides
    @Singleton
    Authenticator provideAuthenticator(final AppConfig appConfig) {
        // Automatically Retry 401 Requests
        return new Authenticator() {

            private int mCounter = 0;

            @Override
            public Request authenticate(Route route, Response response) throws IOException {

                //not including any authentication since there is none.
                return null;
            }
        };
    }


    @Provides
    @Singleton
    Interceptor authorizationInterceptor(final AppConfig appConfig) {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                // Build new request
                Request.Builder builder = request.newBuilder();

                // Override old request
                request = builder.build();
                Response response = chain.proceed(request); //perform request, here original request will be executed

                return response;
            }

            private void setAuthenticationHeader(Request.Builder builder, String accessToken) {
                builder.header("Authorization", String.format("Bearer %s", accessToken));
            }

        };
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(ApiConfig apiConfig, Authenticator authenticator,
                                     Interceptor authorizationInterceptor) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (apiConfig.isDebugBuild()) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(authorizationInterceptor)
                .authenticator(authenticator)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @SuppressLint("SimpleDateFormat")
    @Provides
    @Singleton
    JacksonConverterFactory provideJacksonConverterFactory() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        return JacksonConverterFactory
                .create(objectMapper);
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(ApiConfig apiConfig,
                                    JacksonConverterFactory jacksonConverterFactory,
                                    OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(apiConfig.getApiUrl())
                .client(okHttpClient)
                .addConverterFactory(jacksonConverterFactory)
                .build();
    }

    @Provides
    @Singleton
    public IApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(IApiService.class);
    }


}
