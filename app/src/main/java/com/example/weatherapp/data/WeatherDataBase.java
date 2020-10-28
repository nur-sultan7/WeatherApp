package com.example.weatherapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.weatherapp.pojo.WeatherResponse;

@Database(entities = {WeatherResponse.class},version = 3,exportSchema = false)
public abstract class WeatherDataBase extends RoomDatabase {
    private static WeatherDataBase database;
    private static String DB_NAME="weather_db";
    private static final Object LOCK= new Object();

    public static WeatherDataBase getInstance(Context context)
    {
        synchronized (LOCK)
        {
            if (database==null)
                database= Room.databaseBuilder(context,WeatherDataBase.class,DB_NAME).fallbackToDestructiveMigration().build();
        }
        return database;

    }

    public abstract WeatherDao WeatherDao();
}
