package com.example.springbootproject.NEW.API.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceCreateRequest {
    private String placeName;
    private String countryName;
    private String type;
    private double latitude;
    private double longitude;
}
