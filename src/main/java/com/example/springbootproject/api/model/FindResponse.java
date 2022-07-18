package com.example.springbootproject.api.model;

import com.example.springbootproject.domain.model.Place;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
@Builder
public class FindResponse {
    private List<Place> placeList;
}
