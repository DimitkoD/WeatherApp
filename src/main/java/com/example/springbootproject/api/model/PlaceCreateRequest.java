package com.example.springbootproject.api.model;

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
