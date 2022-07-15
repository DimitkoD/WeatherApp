package com.example.springbootproject.data.db.repository;

import com.example.springbootproject.data.db.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String name);

    @Override
    boolean existsById(Long aLong);
}
