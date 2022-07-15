package com.example.springbootproject.OLD.Services;

import com.example.springbootproject.OLD.DomainModel.Coordinates;
import com.example.springbootproject.OLD.DomainModel.Weather;

public interface WeatherServices {
    public Weather getMyWeather(Coordinates coordinates);
}
