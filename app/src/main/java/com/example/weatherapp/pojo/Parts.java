package com.example.weatherapp.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parts {


    @SerializedName("day")
    @Expose
    private PartOfDay day;
    @SerializedName("morning")
    @Expose
    private PartOfDay morning;
    @SerializedName("night")
    @Expose
    private PartOfDay night;
    @SerializedName("evening")
    @Expose
    private PartOfDay evening;
    @SerializedName("day_short")
    @Expose
    private DayShort dayShort;
    @SerializedName("night_short")
    @Expose
    private NightShort nightShort;

    public PartOfDay getDay() {
        return day;
    }

    public void setDay(PartOfDay day) {
        this.day = day;
    }

    public PartOfDay getMorning() {
        return morning;
    }

    public void setMorning(PartOfDay morning) {
        this.morning = morning;
    }

    public PartOfDay getNight() {
        return night;
    }

    public void setNight(PartOfDay night) {
        this.night = night;
    }

    public PartOfDay getEvening() {
        return evening;
    }

    public void setEvening(PartOfDay evening) {
        this.evening = evening;
    }

    public DayShort getDayShort() {
        return dayShort;
    }

    public void setDayShort(DayShort dayShort) {
        this.dayShort = dayShort;
    }

    public NightShort getNightShort() {
        return nightShort;
    }

    public void setNightShort(NightShort nightShort) {
        this.nightShort = nightShort;
    }

}
