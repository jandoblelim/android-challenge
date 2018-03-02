package com.jandoblelim.androidchallengejanlim.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.jandoblelim.androidchallengejanlim.api.IApiService;
import com.jandoblelim.androidchallengejanlim.api.model.response.ForecastResponse;
import com.jandoblelim.androidchallengejanlim.app.App;
import com.jandoblelim.androidchallengejanlim.database.model.Currently;
import com.jandoblelim.androidchallengejanlim.database.model.DailyData;
import com.jandoblelim.androidchallengejanlim.events.WeatherEvent;
import com.squareup.otto.Bus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.realm.RealmList;
import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;

import static android.content.ContentValues.TAG;

/**
 * Created by devskywalker on 1/3/18.
 */

public class DarkSkyService extends Service {

    private static final String LOG_TAG = "DARKSKY_SERVICE";

    @Inject
    Bus mBus;

    @Inject
    IApiService mApiService;

    public DarkSkyService() {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.i(LOG_TAG, "onCreated");

        DaggerIDarkSkyComponent.builder()
                .iAppComponent(App.getAppComponent(getApplication()))
                .build()
                .inject(this);

        super.onCreate();
        mBus.register(this);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(LOG_TAG, "Service started");
        final Handler handler = new Handler();
        final int delay = 10000; //milliseconds

        handler.postDelayed(new Runnable(){
            public void run(){
                Call<ForecastResponse> call = mApiService.getForecast();
                call.enqueue(new ForecastResponseCallback());
                handler.postDelayed(this, delay);
            }
        }, delay);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(LOG_TAG, "onDestroy");
        super.onDestroy();
        mBus.unregister(this);
    }


    private class ForecastResponseCallback implements retrofit2.Callback<ForecastResponse> {
        @Override
        public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
            Log.i(LOG_TAG, "onResponse");
            App.API_HIT_COUNTER += 1;

            WeatherEvent weatherEvent = new WeatherEvent();
            Currently currently = response.body().getCurrently();

            Date date = new Date(currently.getTime()*1000L); // *1000 is to convert seconds to milliseconds
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // the format of your date
            sdf.setTimeZone(TimeZone.getTimeZone("UTC-8"));

            weatherEvent.setDate(sdf.format(date));
            weatherEvent.setSummary(currently.getSummary());
            weatherEvent.setTemperature(String.valueOf(currently.getTemperature()));
            weatherEvent.setWindspeed(String.valueOf(currently.getWindSpeed()));

            mBus.post(weatherEvent);
        }

        @Override
        public void onFailure(Call<ForecastResponse> call, Throwable t) {
            Log.i(LOG_TAG, "onFailure");
            App.API_HIT_COUNTER += 1;
        }
    }
}
