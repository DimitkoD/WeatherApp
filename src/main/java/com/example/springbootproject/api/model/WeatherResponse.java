package com.example.springbootproject.api.model;

import lombok.*;

@Getter
@Setter
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
