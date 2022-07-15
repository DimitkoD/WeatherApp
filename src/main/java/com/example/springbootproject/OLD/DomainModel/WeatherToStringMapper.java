package com.example.springbootproject.OLD.DomainModel;

public class WeatherToStringMapper {
    public String mapToString(Weather weather) {
        StringBuilder myStringWeather = new StringBuilder();
        myStringWeather.append("Location: ");
        myStringWeather.append(weather.getLocation());
        myStringWeather.append(", Temperature: ");
        myStringWeather.append(weather.getTemperature());
        myStringWeather.append(", Humidity: ");
        myStringWeather.append(weather.getPercentHumidity());
        myStringWeather.append(", The weather is: ");
        myStringWeather.append(weather.getSky());

        return myStringWeather.toString();
    }
}
