package com.example.springbootproject.Data.DB.Repository;

import com.example.springbootproject.Data.DB.Entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    Place findByNameAndCountryName(String placeName, String countryName);
    Optional<Place> findById(Long id);
}
