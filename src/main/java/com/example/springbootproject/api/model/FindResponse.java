package com.example.springbootproject.api.model;

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
