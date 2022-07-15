package com.example.springbootproject.OLD.DomainModel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Builder
@ToString
public class Weather {
    private String location;
    private double temperature;
    private String sky;
    private int percentHumidity;
}
