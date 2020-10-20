package com.example.weatherapp.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lon")
    @Expose
    private double lon;
    @SerializedName("tzinfo")
    @Expose
    private Tzinfo tzinfo;
    @SerializedName("def_pressure_mm")
    @Expose
    private int defPressureMm;
    @SerializedName("def_pressure_pa")
    @Expose
    private int defPressurePa;
    @SerializedName("url")
    @Expose
    private String url;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Tzinfo getTzinfo() {
        return tzinfo;
    }

    public void setTzinfo(Tzinfo tzinfo) {
        this.tzinfo = tzinfo;
    }

    public int getDefPressureMm() {
        return defPressureMm;
    }

    public void setDefPressureMm(int defPressureMm) {
        this.defPressureMm = defPressureMm;
    }

    public int getDefPressurePa() {
        return defPressurePa;
    }

    public void setDefPressurePa(int defPressurePa) {
        this.defPressurePa = defPressurePa;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}