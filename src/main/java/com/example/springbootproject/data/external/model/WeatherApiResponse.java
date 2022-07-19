package com.example.springbootproject.data.external.model;

import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class WeatherApiResponse {
    public Location location;
    public Current current;
}
