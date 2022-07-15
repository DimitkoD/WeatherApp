package com.example.springbootproject.OLD.Controller;

import com.example.springbootproject.OLD.DomainModel.Coordinates;
import com.example.springbootproject.OLD.DomainModel.WeatherToStringMapper;
import com.example.springbootproject.OLD.Services.LocationServices;
import com.example.springbootproject.OLD.Services.WeatherServices;
import com.example.springbootproject.OLD.Exceptions.LocationNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {
    WeatherServices weatherServices;
    LocationServices locationService;

    public WeatherController(WeatherServices weatherService, LocationServices locationService) {
        this.weatherServices = weatherService;
        this.locationService = locationService;
        System.out.println("Weather controller has been created");
    }

    @RequestMapping("/weather")
    public String getWeather(@RequestBody WeatherInputRequest inputRequest)
    {
        return new WeatherToStringMapper().
            mapToString(weatherServices.
                getMyWeather(
                    new Coordinates(
                        Double.parseDouble(inputRequest.getLatitude()),
                        Double.parseDouble(inputRequest.getLongitude())
                    )
                )
            );
    }

    @PostMapping("/location")
    public String getWeatherForLocation(String location) throws LocationNotFoundException {
        Coordinates coordinates = locationService.findLocation(location);

        return new WeatherToStringMapper().
                mapToString(weatherServices.
                        getMyWeather(coordinates));
    }
}
