package com.example.weatherapp.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tzinfo {

    @SerializedName("offset")
    @Expose
    private int offset;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("abbr")
    @Expose
    private String abbr;
    @SerializedName("dst")
    @Expose
    private boolean dst;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public boolean isDst() {
        return dst;
    }

    public void setDst(boolean dst) {
        this.dst = dst;
    }

}