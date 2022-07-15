package com.example.springbootproject.NEW.API.Model;

import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@ToString
public class WeatherResponse {
    private String country;
    private String place;
    private String type;
    private double temperature;
    private String sky;
    private double humidity;
}
