package com.main.patterns.observer.push;

public class CurrentConditionsDisplay implements WeatherObserver{

    private  WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
    }
    @Override
    public void update(WeatherData weatherData) {
        this.weatherData=  weatherData;
    }
    @Override
    public String getWeatherData(){
        System.out.println("Current conditions display received for current display " + weatherData.toString());
        return weatherData.toString();
    }
}
