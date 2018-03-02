package com.jandoblelim.androidchallengejanlim.api;

/**
 * Created by devskywalker on 03/1/18.
 */

public interface IApiAuthenticator {

    int refreshToken();

    void forceLogout();
}