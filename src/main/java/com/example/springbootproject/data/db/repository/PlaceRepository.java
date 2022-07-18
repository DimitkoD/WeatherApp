package com.example.springbootproject.data.db.repository;

import com.example.springbootproject.data.db.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity, Long> {
    PlaceEntity findByNameAndCountryName(String placeName, String countryName);
    Optional<PlaceEntity> findById(Long id);
    List<PlaceEntity> findAllByName(String name);
}
