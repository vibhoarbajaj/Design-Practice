package com.main.patterns.observer.push;




import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements WeatherObservable {

    private final List<WeatherObserver> observers ;

    private WeatherData weatherData;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }


    @Override
    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("notifying the  observers with size "+ observers.size() );
        for(WeatherObserver observer : observers){
            observer.update(weatherData);
        }
    }

    @Override
    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
        notifyObservers();
    }
}
