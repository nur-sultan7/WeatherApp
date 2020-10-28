package com.example.weatherapp.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.weatherapp.pojo.WeatherResponse;

import java.util.List;

@Dao
public interface WeatherDao {
    @Insert
    void insertWeatherList(List<WeatherResponse> weatherResponseList);
    @Insert
    void insertWeatherResponse(WeatherResponse weatherResponse);
    @Query("select * from cities_weather where info= :info")
    WeatherResponse getWeatherResponse(String info);
    @Query("delete from cities_weather")
    void deleteWeatherList();
    @Query("select * from cities_weather")
    List<WeatherResponse> getWeatherList();
}
