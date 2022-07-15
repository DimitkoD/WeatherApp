package com.example.springbootproject.data.db.repository;

import com.example.springbootproject.data.db.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    Place findByNameAndCountryName(String placeName, String countryName);
    Optional<Place> findById(Long id);
}
