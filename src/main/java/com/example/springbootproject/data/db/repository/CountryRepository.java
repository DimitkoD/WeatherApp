package com.example.springbootproject.data.db.repository;

import com.example.springbootproject.data.db.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
     Country findByName(String name);

     @Override
     boolean existsById(Long aLong);
}
