package com.example.springbootproject.Data.DB.Entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private long countryId;
    private long typeId;

    @ManyToOne
    @JoinColumn(name = "countryId", insertable = false, updatable = false)
    private Country country;
    @ManyToOne
    @JoinColumn(name = "typeId", insertable = false, updatable = false)
    private Type type;
}
