package com.example.springbootproject.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WeatherRequest {
    @JsonProperty("място")
    private String placeName;
    @JsonProperty("държава")
    private String countryName;
    @JsonProperty("фаренхайт")
    private String isFahrenheit;
}
