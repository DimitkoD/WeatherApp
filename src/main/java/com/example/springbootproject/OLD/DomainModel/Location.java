package com.example.springbootproject.OLD.DomainModel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Location {

    private String label;
    private double latitude;
    private double longitude;

}
