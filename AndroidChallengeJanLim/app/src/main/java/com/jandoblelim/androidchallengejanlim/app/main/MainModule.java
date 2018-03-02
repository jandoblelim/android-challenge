package com.jandoblelim.androidchallengejanlim.app.main;

import com.jandoblelim.androidchallengejanlim.app.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by devskywalker on 03/1/18.
 */

@Module
class MainModule {
    private final IMainContract.View mHomeView;

    MainModule(IMainContract.View homeView) { mHomeView = homeView; }

    @Provides
    @ActivityScope
    IMainContract.View provideHomeView() { return mHomeView; }
}
