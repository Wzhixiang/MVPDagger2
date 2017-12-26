package com.wzx.mvpdagger2.bean;

import com.google.gson.annotations.SerializedName;

public class Future24 {
/*  "text":"多云",
    "code":"4",
    "temperature":"16",
    "time":"2017-02-19T13:00:00+08:00"*/

    @SerializedName("text")
    private String weatherType;
    private String code;
    private String temperature;
    private String time;

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
