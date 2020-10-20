package com.example.weatherapp.api;

import android.database.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    String PARAM_LAT="lat";
    String PARAM_LON="lon";
    String PARAM_LANG="lang";
    @GET("forecast?")
    Observable<String> getWhether(@Query(PARAM_LAT) String lat, @Query(PARAM_LON) String lon);
}
