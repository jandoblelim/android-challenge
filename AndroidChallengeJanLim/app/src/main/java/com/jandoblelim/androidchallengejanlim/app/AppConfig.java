package com.jandoblelim.androidchallengejanlim.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by devskywalker on 03/1/18.
 */

public class AppConfig {
    private final SharedPreferences mSharedPreferences;

    public AppConfig(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }
}
