package com.example.weatherapp.api;

import com.example.weatherapp.pojo.WeatherResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {
    String PARAM_LAT="lat";
    String PARAM_LON="lon";
    String PARAM_LANG="lang";

    @Headers("X-Yandex-API-Key: 6ca64493-30ac-4387-9e79-c94f4de63488")
    @GET("forecast")
    Observable<WeatherResponse> getWhether(@Query(PARAM_LAT) Double lat, @Query(PARAM_LON) Double lon);
}
