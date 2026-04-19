package com.main.patterns.observer.push;

public class ForecastConditionsDisplay implements WeatherObserver{

    private  WeatherData weatherData;
    public ForecastConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
    }
    @Override
    public void update(WeatherData weatherData) {
        this.weatherData=  weatherData;
    }
    @Override
    public String getWeatherData(){
        System.out.println("Current conditions display received for forecastdisplay " + this.weatherData.toString());
        return weatherData.toString();
    }
}
