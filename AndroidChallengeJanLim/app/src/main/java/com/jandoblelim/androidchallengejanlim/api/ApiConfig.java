package com.jandoblelim.androidchallengejanlim.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;

/**
 * Created by devskywalker on 03/1/18.
 */

public class ApiConfig {
    private static final String KEY_API_CONFIG = "api_config";
    private static final String KEY_API_URL = "api_url";

    private final SharedPreferences mSharedPreferences;
    private final String DEFAULT_API_URL;

    private boolean mIsDebugBuild;

    public ApiConfig(Context context) {
        mSharedPreferences = context.getSharedPreferences(KEY_API_CONFIG, Context.MODE_PRIVATE);

        DEFAULT_API_URL = "https://api.darksky.net/";

        mIsDebugBuild = 0 != (context.getApplicationInfo().flags & ApplicationInfo
                .FLAG_DEBUGGABLE);
    }

    public String getApiUrl() {
        return mSharedPreferences.getString(KEY_API_URL, DEFAULT_API_URL);
    }


    public boolean isDebugBuild() {
        return mIsDebugBuild;
    }

}