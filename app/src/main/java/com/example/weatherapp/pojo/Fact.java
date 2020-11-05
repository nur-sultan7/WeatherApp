package com.example.weatherapp.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fact {



    @SerializedName("temp")
    @Expose
    private int temp;
    @SerializedName("feels_like")
    @Expose
    private int feelsLike;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("wind_speed")
    @Expose
    private double windSpeed;
    @SerializedName("wind_gust")
    @Expose
    private double windGust;
    @SerializedName("wind_dir")
    @Expose
    private String windDir;
    @SerializedName("pressure_mm")
    @Expose
    private int pressureMm;
    @SerializedName("pressure_pa")
    @Expose
    private int pressurePa;
    @SerializedName("humidity")
    @Expose
    private int humidity;
    @SerializedName("daytime")
    @Expose
    private String daytime;
    @SerializedName("polar")
    @Expose
    private boolean polar;
    @SerializedName("season")
    @Expose
    private String season;
    @SerializedName("prec_type")
    @Expose
    private int precType;
    @SerializedName("prec_strength")
    @Expose
    private double precStrength;
    @SerializedName("is_thunder")
    @Expose
    private boolean isThunder;
    @SerializedName("cloudness")
    @Expose
    private double cloudness;
    @SerializedName("obs_time")
    @Expose
    private int obsTime;
    @SerializedName("phenom_icon")
    @Expose
    private String phenomIcon;
    @SerializedName("phenom-condition")
    @Expose
    private String phenomCondition;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(int feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindGust() {
        return windGust;
    }

    public void setWindGust(double windGust) {
        this.windGust = windGust;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public int getPressureMm() {
        return pressureMm;
    }

    public void setPressureMm(int pressureMm) {
        this.pressureMm = pressureMm;
    }

    public int getPressurePa() {
        return pressurePa;
    }

    public void setPressurePa(int pressurePa) {
        this.pressurePa = pressurePa;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public boolean isPolar() {
        return polar;
    }

    public void setPolar(boolean polar) {
        this.polar = polar;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getPrecType() {
        return precType;
    }

    public void setPrecType(int precType) {
        this.precType = precType;
    }

    public double getPrecStrength() {
        return precStrength;
    }

    public void setPrecStrength(double precStrength) {
        this.precStrength = precStrength;
    }

    public boolean isIsThunder() {
        return isThunder;
    }

    public void setIsThunder(boolean isThunder) {
        this.isThunder = isThunder;
    }

    public double getCloudness() {
        return cloudness;
    }

    public void setCloudness(double cloudness) {
        this.cloudness = cloudness;
    }

    public int getObsTime() {
        return obsTime;
    }

    public void setObsTime(int obsTime) {
        this.obsTime = obsTime;
    }

    public String getPhenomIcon() {
        return phenomIcon;
    }

    public void setPhenomIcon(String phenomIcon) {
        this.phenomIcon = phenomIcon;
    }

    public String getPhenomCondition() {
        return phenomCondition;
    }

    public void setPhenomCondition(String phenomCondition) {
        this.phenomCondition = phenomCondition;
    }

}