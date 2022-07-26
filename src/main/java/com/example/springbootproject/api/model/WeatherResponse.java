package com.example.springbootproject.api.model;

import com.example.springbootproject.api.deserializer.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;


@Getter
@Setter
@Builder
@ToString
public class WeatherResponse {
    @JsonView(Views.Public.class)
    private String country;
    @JsonView(Views.Public.class)
    private String place;
    @JsonView(Views.Internal.class)
    private String type;
    @JsonView(Views.Public.class)
    private double temperature;
    @JsonView(Views.Internal.class)
    private String sky;
    @JsonView(Views.Internal.class)
    private double humidity;
}
