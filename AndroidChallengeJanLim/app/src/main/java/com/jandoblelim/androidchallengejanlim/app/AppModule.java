package com.jandoblelim.androidchallengejanlim.app;

import android.app.Application;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by devskywalker on 03/1/18.
 */

@Module
public class AppModule {

    private final Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    AppConfig provideAppConfig() {
        return new AppConfig(mApplication);
    }

    @Provides
    @Singleton
    public Bus provideBus() {
        return new Bus(ThreadEnforcer.ANY);
    }

}
