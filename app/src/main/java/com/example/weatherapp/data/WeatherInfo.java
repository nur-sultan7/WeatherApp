package com.example.weatherapp.data;

import java.util.HashMap;
import java.util.Map;

public class WeatherInfo {
    private static Map<String,String> conditionListInRussian = new HashMap<String, String>(){{
        put("clear"," ясно");
        put("partly-cloudy","малооблачно");
        put("cloudy","облачно с прояснениями");
        put("overcast","пасмурно");
        put("drizzle","морось");
        put("light-rain","небольшой дождь");
        put("rain","дождь");
        put("moderate-rain","умеренно сильный дождь");
        put("heavy-rain","сильный дождь");
        put("continuous-heavy-rain","длительный сильный дождь");
        put("showers","ливень");
        put("wet-snow"," дождь со снегом");
        put("light-snow","небольшой снег");
        put("snow","снег");
        put("snow-showers","снегопад");
        put("hail","град");
        put("thunderstorm","гроза");
        put("thunderstorm-with-rain","дождь с грозой");
        put("thunderstorm-with-hail"," гроза с градом");
    }};
    private static Map<String,String> windInfoListInRussian = new HashMap<String, String>(){{
        put("nw","северо-западное");
        put("n","северное");
        put("ne","северо-восточное");
        put("e","восточное");
        put("se","юго-восточное");
        put("s","южное");
        put("sw","юго-западное");
        put("w","западное");
        put("с","штиль");
    }};
    private static Map<Integer,String> dayOfWeek = new HashMap<Integer, String>(){
        {
            put(0,"Воскресенье");
            put(1,"Понедельник");
            put(2,"Вторник");
            put(3,"Среда");
            put(4,"Четверг");
            put(5,"Пятница");
            put(6,"Суббота");

        }
    };

    private static String weatherIcon= "https://yastatic.net/weather/i/icons/blueye/color/svg/%s.svg";
    public static String getWeatherIcon(String icon) {
        return String.format(weatherIcon, icon);
    }

    public static String getConditionInRussian(String condition)
    {
        return conditionListInRussian.get(condition);
    }

    public static String getWindInfoListInRussian(String windInfo) {
        return windInfoListInRussian.get(windInfo);
    }
    public static String getDayOfWeek(Integer dayNumber)
    {
        return dayOfWeek.get(dayNumber);
    }
}
