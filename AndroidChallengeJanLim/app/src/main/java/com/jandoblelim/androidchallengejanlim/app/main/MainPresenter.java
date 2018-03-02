package com.jandoblelim.androidchallengejanlim.app.main;

import com.jandoblelim.androidchallengejanlim.api.IApiService;
import com.jandoblelim.androidchallengejanlim.events.WeatherEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

/**
 * Created by devskywalker on 03/1/18.
 */

public class MainPresenter implements IMainContract.Presenter {

    private IMainContract.View mMainView;
    private IApiService mApiService;
    private Bus mBus;

    @Inject
    MainPresenter(IMainContract.View mainView, IApiService apiService, Bus bus) {
        mMainView = mainView;
        mApiService = apiService;
        mBus = bus;
    }

    @Override
    public void onResume() {

    }

    public void onDestroy() {
        mMainView = null;
    }


    @Override
    public void onStart() {
        mBus.register(this);
    }

    @Override
    public void onStop() {
        mBus.unregister(this);
    }

    @Subscribe
    public void onSubscribeWeatherEvent(WeatherEvent weatherEvent) {
        mMainView.renderView(weatherEvent);
    }

}
