package com.example.springbootproject.API.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRequest {
    private Long id;
    private String placeName;
    private String countryName;
    private String type;
    private double latitude;
    private double longitude;
}
