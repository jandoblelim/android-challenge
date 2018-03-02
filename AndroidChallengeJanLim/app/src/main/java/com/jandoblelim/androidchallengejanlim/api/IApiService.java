package com.jandoblelim.androidchallengejanlim.api;

import com.jandoblelim.androidchallengejanlim.api.model.response.ForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by devskywalker on 03/1/18.
 */

public interface IApiService {

    @GET("forecast/d52ed8b07ea9f25967162f8c4ac200c9/37.8267,-122.4233")
    Call<ForecastResponse> getForecast();
}
