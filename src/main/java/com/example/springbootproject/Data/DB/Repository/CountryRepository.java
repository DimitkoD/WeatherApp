package com.example.springbootproject.Data.DB.Repository;

import com.example.springbootproject.Data.DB.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
     Country findByName(String name);

     @Override
     boolean existsById(Long aLong);
}