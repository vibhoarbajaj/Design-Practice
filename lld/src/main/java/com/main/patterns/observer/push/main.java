package com.main.patterns.observer.push;

public class main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        weatherData.setTemperature("1");
        weatherData.setHumidity("1");

        WeatherData weatherData1 = new WeatherData();
        weatherData1.setTemperature("2");
        weatherData1.setHumidity("2");

        WeatherData weatherData2 = new WeatherData();
        weatherData2.setTemperature("3");
        weatherData2.setHumidity("3");


        WeatherObserver currentConditionsDisplay = new CurrentConditionsDisplay(weatherData1);
        WeatherObserver forecastConditionsDisplay = new ForecastConditionsDisplay(weatherData2);

        WeatherStation weatherStation = new WeatherStation();
        weatherStation.setWeatherData(weatherData);

        currentConditionsDisplay.getWeatherData();
        forecastConditionsDisplay.getWeatherData();

        weatherStation.addObserver(currentConditionsDisplay);
        weatherStation.addObserver(forecastConditionsDisplay);


        weatherStation.setWeatherData(weatherData);
        currentConditionsDisplay.getWeatherData();
        forecastConditionsDisplay.getWeatherData();

        weatherStation.setWeatherData(weatherData1);
        weatherStation.setWeatherData(weatherData2);

        currentConditionsDisplay.getWeatherData();
        forecastConditionsDisplay.getWeatherData();

    }
}
