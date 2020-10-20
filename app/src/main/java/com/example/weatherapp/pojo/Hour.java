package com.example.weatherapp.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hour {

    @SerializedName("hour")
    @Expose
    private String hour;
    @SerializedName("hour_ts")
    @Expose
    private int hourTs;
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
    @SerializedName("is_thunder")
    @Expose
    private boolean isThunder;
    @SerializedName("cloudness")
    @Expose
    private int cloudness;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getHourTs() {
        return hourTs;
    }

    public void setHourTs(int hourTs) {
        this.hourTs = hourTs;
    }

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

    public boolean isIsThunder() {
        return isThunder;
    }

    public void setIsThunder(boolean isThunder) {
        this.isThunder = isThunder;
    }

    public int getCloudness() {
        return cloudness;
    }

    public void setCloudness(int cloudness) {
        this.cloudness = cloudness;
    }

}
