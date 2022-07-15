package com.example.springbootproject.OLD.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherStationController {

    @RequestMapping("/weatherStation")
    public String getStation(@RequestBody StationInputRequest inputRequest)
    {
        return inputRequest.toString();
    }
}
