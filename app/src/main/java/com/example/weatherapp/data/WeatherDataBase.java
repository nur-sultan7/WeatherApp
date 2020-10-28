package com.example.weatherapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {},version = 1,exportSchema = false)
public abstract class WeatherDataBase extends RoomDatabase {
    private static WeatherDataBase database;
    private static String DB_NAME="weather_db";
    private static final Object LOCK= new Object();

    static WeatherDataBase getInstance(Context context)
    {
        synchronized (LOCK)
        {
            if (database==null)
                database= Room.databaseBuilder(context,WeatherDataBase.class,DB_NAME).build();
        }
        return database;

    }

    public abstract WeatherDao WeatherDao();
}
