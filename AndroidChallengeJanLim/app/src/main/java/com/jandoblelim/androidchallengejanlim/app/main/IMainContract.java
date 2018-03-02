package com.jandoblelim.androidchallengejanlim.app.main;

import com.jandoblelim.androidchallengejanlim.events.WeatherEvent;

/**
 * Created by devskywalker on 03/1/18.
 */

public interface IMainContract {

    interface View {

        void showRefreshing(boolean b);

        void showErrorDialog();

        void renderView(WeatherEvent weatherEvent);
    }

    interface Presenter {

        void onResume();

        void onDestroy();

        void onStart();

        void onStop();
    }
}
