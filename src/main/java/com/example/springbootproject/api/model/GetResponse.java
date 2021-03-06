package com.example.springbootproject.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class GetResponse {
    private String placeName;
    private String countryName;
    private String type;
    private double latitude;
    private double longitude;
}
