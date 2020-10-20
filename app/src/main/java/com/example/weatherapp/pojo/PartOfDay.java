package com.example.weatherapp.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartOfDay {
    @SerializedName("temp_min")
    @Expose
    private int tempMin;
    @SerializedName("temp_max")
    @Expose
    private int tempMax;
    @SerializedName("temp_avg")
    @Expose
    private int tempAvg;
    @SerializedName("feels_like")
    @Expose
    private int feelsLike;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("daytime")
    @Expose
    private String daytime;
    @SerializedName("polar")
    @Expose
    private boolean polar;
    @SerializedName("wind_speed")
    @Expose
    private double windSpeed;
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
    @SerializedName("prec_mm")
    @Expose
    private double precMm;
    @SerializedName("prec_period")
    @Expose
    private int precPeriod;
    @SerializedName("prec_type")
    @Expose
    private int precType;
    @SerializedName("prec_strength")
    @Expose
    private double precStrength;
    @SerializedName("cloudness")
    @Expose
    private double cloudness;

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempAvg() {
        return tempAvg;
    }

    public void setTempAvg(int tempAvg) {
        this.tempAvg = tempAvg;
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

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
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

    public double getPrecMm() {
        return precMm;
    }

    public void setPrecMm(double precMm) {
        this.precMm = precMm;
    }

    public int getPrecPeriod() {
        return precPeriod;
    }

    public void setPrecPeriod(int precPeriod) {
        this.precPeriod = precPeriod;
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

    public double getCloudness() {
        return cloudness;
    }

    public void setCloudness(double cloudness) {
        this.cloudness = cloudness;
    }

}
