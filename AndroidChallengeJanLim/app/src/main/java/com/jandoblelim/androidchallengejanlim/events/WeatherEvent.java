package com.jandoblelim.androidchallengejanlim.events;

/**
 * Created by devskywalker on 2/3/18.
 */

public class WeatherEvent {

    public WeatherEvent() {

    }

    public String date;
    public String temperature;
    public String summary;
    public String windspeed;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
    }


}
