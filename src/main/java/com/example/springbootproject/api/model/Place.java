package com.example.springbootproject.api.model;

import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@ToString
public class Place {
    private String name;
    private String country;
    private double latitude;
    private double longitude;
    private String type;
}
