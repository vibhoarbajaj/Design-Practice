package com.main.patterns.observer.push;

public interface WeatherObserver {
    void update(WeatherData weatherData);
    String getWeatherData();
}
