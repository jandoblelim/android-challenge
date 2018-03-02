package com.jandoblelim.androidchallengejanlim.api;

import com.jandoblelim.androidchallengejanlim.api.model.response.ForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by devskywalker on 03/1/18.
 */

public interface IApiService {

    @GET("forecast/c63d1a62f0f56add8fff7deb5f217aac/37.8267,-122.4233")
    Call<ForecastResponse> getForecast();
}
