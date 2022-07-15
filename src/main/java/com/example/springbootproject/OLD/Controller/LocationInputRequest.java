package com.example.springbootproject.OLD.Controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationInputRequest {
    private String label;
    private double latitude;
    private double longitude;
}
