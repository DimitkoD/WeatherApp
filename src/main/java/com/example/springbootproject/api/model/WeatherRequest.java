package com.example.springbootproject.api.model;

import com.example.springbootproject.api.deserializer.RequestDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    @JsonDeserialize(using = RequestDeserializer.class)
    private boolean isFahrenheit;
    @JsonIgnore
    private String ignore;
}
