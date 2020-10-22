package com.example.weatherapp.data;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String name;
    private double lat;
    private double lon;


    public City(String name, double lat, double lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public static List<City> getRussianCitiesList()
    {
        List<City> cityList = new ArrayList<>();
        cityList.add(new City("Москва",32.544,11.5468));
        cityList.add(new City("Санкт-Петербург",59.938806,30.314278));
        cityList.add(new City("Ростов-на-Дону",47.227151,39.744972));
        cityList.add(new City("Грозный",43.317992,45.698197));
        cityList.add(new City("Сочи",43.581509,39.722882));
        cityList.add(new City("Махачкала",42.984913,47.504646));
        cityList.add(new City("Краснодар",45.023877,38.970157));
        cityList.add(new City("Казань",55.795793,49.106585));
        cityList.add(new City("Волгоград",48.707103,44.516939 ));
        cityList.add(new City("Новосибирск",55.028739,82.90692799999999 ));
        cityList.add(new City("Омск",54.989342,73.368212  ));
        return cityList;
    }
    public static List<City> getEuropeanCitiesList()
    {
        List<City> cityList = new ArrayList<>();
        cityList.add(new City("Киев",50.467418, 30.531860));
        cityList.add(new City("Минск",53.926452, 27.543578));
        cityList.add(new City("Прага",50.068723, 14.40647));
        cityList.add(new City("Мюнхен",48.131858, 11.517697));
        cityList.add(new City("Варшава",52.230023, 21.020870));
        cityList.add(new City("Вена",48.212452, 16.340695));
        cityList.add(new City("Амстердам",52.377816, 4.881954));
        cityList.add(new City("Париж",48.855007, 2.317929));
        cityList.add(new City("Барселона",41.388420, 2.173207));
        cityList.add(new City("Мадрид",40.433641, -3.734691));
        cityList.add(new City("Лиссабон",8.725650, -9.150795));
        cityList.add(new City("Рим",41.895208, 12.442955));
        return cityList;
    }

}
