package com.example.springbootproject.OLD.Services.implementations;

import com.example.springbootproject.OLD.DomainModel.Coordinates;
import com.example.springbootproject.OLD.DomainModel.Weather;
import com.example.springbootproject.OLD.Services.WeatherServices;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
public class TestWeatherService implements WeatherServices {
    public TestWeatherService() {
        System.out.println("TestWeather impl has been created");
    }

    @Override
    public Weather getMyWeather(Coordinates coordinates) {
        return Weather.builder().location("Varna").temperature(25.5).sky("sunny").percentHumidity(25).build();
    }
}
