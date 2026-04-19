package com.main.patterns.observer.push;

public interface WeatherObservable {
    void addObserver(WeatherObserver observer);

    void removeObserver(WeatherObserver observer);

    void notifyObservers();

    void setWeatherData(WeatherData weatherData);
}
