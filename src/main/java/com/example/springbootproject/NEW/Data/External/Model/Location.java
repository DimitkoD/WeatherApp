package com.example.springbootproject.NEW.Data.External.Model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter(AccessLevel.PRIVATE)
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
