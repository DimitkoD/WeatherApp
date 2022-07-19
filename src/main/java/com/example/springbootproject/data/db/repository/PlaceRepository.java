package com.example.springbootproject.data.db.repository;

import com.example.springbootproject.data.db.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity, Long> {
    PlaceEntity findByNameAndCountryName(String placeName, String countryName);
    Optional<PlaceEntity> findById(Long id);
    @Query("FROM PlaceEntity place WHERE place.name LIKE :name%")
    List<PlaceEntity> findAllByName(@Param("name") String placeName);

}
