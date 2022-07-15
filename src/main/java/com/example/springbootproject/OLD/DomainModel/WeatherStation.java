package com.example.springbootproject.OLD.DomainModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class WeatherStation {
    private double latitude;
    private double longitude;
    private String location;
    private double seaLevel;
    private String type;
}
