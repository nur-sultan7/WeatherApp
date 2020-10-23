package com.example.weatherapp.data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeatherInfo {
    private Map<String,String> conditionListInRussian = new HashMap<>();
    public WeatherInfo()
    {
        conditionListInRussian.put("clear"," ясно");
        conditionListInRussian.put("partly-cloudy","малооблачно");
        conditionListInRussian.put("cloudy","облачно с прояснениями");
        conditionListInRussian.put("overcast","пасмурно");
        conditionListInRussian.put("drizzle","морось");
        conditionListInRussian.put("light-rain","небольшой дождь");
        conditionListInRussian.put("rain","дождь");
        conditionListInRussian.put("moderate-rain","умеренно сильный дождь");
        conditionListInRussian.put("heavy-rain","сильный дождь");
        conditionListInRussian.put("continuous-heavy-rain","длительный сильный дождь");
        conditionListInRussian.put("showers","ливень");
        conditionListInRussian.put("wet-snow"," дождь со снегом");
        conditionListInRussian.put("light-snow","небольшой снег");
        conditionListInRussian.put("snow","снег");
        conditionListInRussian.put("snow-showers","снегопад");
        conditionListInRussian.put("hail","град");
        conditionListInRussian.put("thunderstorm","гроза");
        conditionListInRussian.put("thunderstorm-with-rain","дождь с грозой");
        conditionListInRussian.put("thunderstorm-with-hail"," гроза с градом");
    }
    public  String getConditionInRussian(String condition)
    {
        return conditionListInRussian.get(condition);
    }
}