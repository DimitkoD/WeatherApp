package com.example.springbootproject.OLD.RequestModel.WeatherRequest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class Location {
    public String name;
    public String region;
    public String country;
    public double lat;
    public double lon;
    public String tz_id;
    public int localtime_epoch;
    public String localtime;
}
