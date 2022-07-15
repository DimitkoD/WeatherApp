package com.example.springbootproject.data.external.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class Current{
    public double temp_c;
    public Condition condition;
    public int humidity;
    public double uv;
}
