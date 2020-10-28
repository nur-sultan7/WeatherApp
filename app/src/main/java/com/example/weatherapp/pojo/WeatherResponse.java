package com.example.weatherapp.pojo;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
@Entity(tableName = "cities_weather")
public class WeatherResponse {
    public WeatherResponse(int uniqueId, int now, String nowDt, Info info, Fact fact, List<Forecast> forecasts) {
        this.uniqueId = uniqueId;
        this.now = now;
        this.nowDt = nowDt;
        this.info = info;
        this.fact = fact;
        this.forecasts = forecasts;
    }

    @PrimaryKey(autoGenerate = true)
    private int uniqueId;

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }


    @Ignore
    private static String weatherIcon= "https://yastatic.net/weather/i/icons/blueye/color/svg/%s.svg";
    public String getWeatherIcon(String icon) {
        return String.format(weatherIcon,icon);
    }
    @SerializedName("now")
    @Expose
    private int now;
    @SerializedName("now_dt")
    @Expose
    private String nowDt;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("fact")
    @Expose
    private Fact fact;
    @SerializedName("forecasts")
    @Expose
    private List<Forecast> forecasts = null;

    public int getNow() {
        return now;
    }

    public void setNow(int now) {
        this.now = now;
    }

    public String getNowDt() {
        return nowDt;
    }

    public void setNowDt(String nowDt) {
        this.nowDt = nowDt;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Fact getFact() {
        return fact;
    }

    public void setFact(Fact fact) {
        this.fact = fact;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

}

