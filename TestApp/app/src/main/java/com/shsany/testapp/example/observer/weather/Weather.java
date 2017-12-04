package com.shsany.testapp.example.observer.weather;

/**
 * Created by PC on 2017/11/30.
 * Weather实体类
 */

public class Weather {

    private String description;

    public Weather(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weather {description='" + description + "'}";
    }
}
