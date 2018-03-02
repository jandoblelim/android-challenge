package com.jandoblelim.androidchallengejanlim.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.jandoblelim.androidchallengejanlim.api.ApiConfig;
import com.jandoblelim.androidchallengejanlim.api.ApiModule;
import com.jandoblelim.androidchallengejanlim.api.IApiAuthenticator;
import com.jandoblelim.androidchallengejanlim.database.model.DailyData;
import com.jandoblelim.androidchallengejanlim.database.realm.RealmDailyDataRepository;
import com.jandoblelim.androidchallengejanlim.database.realm.RealmDailyRepository;
import com.jandoblelim.androidchallengejanlim.services.DarkSkyService;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by devskywalker on 03/1/18.
 */

public class App extends Application implements IApiAuthenticator {

    private IAppComponent mAppComponent;
    private static DailyData dailyData = null;
    public static Integer API_HIT_COUNTER;

    @Inject
    ApiConfig mApiConfig;

    //entry point to application
    @Override
    public void onCreate() {
        super.onCreate();

        API_HIT_COUNTER = 0;

        //let's initialize the appComponent
        initializeAppComponent();

        //let's intialize the realm repositories
        initRealmRepository();

        //let's start the services
        startDarkSkyService();
    }

    private void startDarkSkyService() {
        //check if service is running
        //if it's running, do nothing
        if(isServiceRunning(DarkSkyService.class, this)) {
            return;
        }

        startService(new Intent(this, DarkSkyService.class));
    }

    private boolean isServiceRunning(Class<?> serviceClass, Context context) {
        final ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RunningServiceInfo> services = activityManager.getRunningServices(Integer.MAX_VALUE);

        for (ActivityManager.RunningServiceInfo runningServiceInfo : services) {
            if (runningServiceInfo.service.getClassName().equals(serviceClass.getName())) {
                return true;
            }
        }
        return false;    }

    private void initRealmRepository() {
        RealmDailyDataRepository.initialize(this);
        RealmDailyRepository.initialize(this);
    }

    private void initializeAppComponent() {
        mAppComponent = null;
        mAppComponent =
                DaggerIAppComponent.builder()
                        .appModule(new AppModule(this))
                        .apiModule(new ApiModule(this))
                        .build();
        mAppComponent.inject(this);
    }

    public IAppComponent getAppComponent() {
        return mAppComponent;
    }

    public static IAppComponent getAppComponent(Application application) {
        return ((App) application).getAppComponent();
    }

    @Override
    public int refreshToken() {
        return -1;
    }

    @Override
    public void forceLogout() {
        // do force logout cleanup here
    }


    /**
     * DailyData
     */
    public static boolean hasDailyData() {
        return dailyData != null;
    }

    public static void setDailyData(final DailyData d) {
        dailyData = d;
    }

    public static DailyData getDailyData() {
        final DailyData result = dailyData;
        dailyData = null;
        return result;
    }
}
