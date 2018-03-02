package com.jandoblelim.androidchallengejanlim.app;

import android.app.Application;
import com.jandoblelim.androidchallengejanlim.api.ApiConfig;
import com.jandoblelim.androidchallengejanlim.api.ApiModule;
import com.jandoblelim.androidchallengejanlim.api.IApiService;
import com.squareup.otto.Bus;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by devskywalker on 03/1/18.
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                ApiModule.class
        }
)
public interface IAppComponent {

    Application application();

    AppConfig appConfig();

    IApiService apiService();

    ApiConfig apiConfig();

    Bus eventBus();

    void inject(App app);

}