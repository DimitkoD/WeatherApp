package com.example.springbootproject.data.external.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class WeatherApiResponse {
    public Location location;
    public Current current;
}
