package com.example.springbootproject.Data.External.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class WeatherApiResponse {
    public Location location;
    public Current current;
}
