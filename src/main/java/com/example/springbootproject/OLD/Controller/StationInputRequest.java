package com.example.springbootproject.OLD.Controller;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
public class StationInputRequest {

    private double latitude;
    private double longitude;
    private String location;
    private double seaLevel;
    private String type;
}
