package com.example.Conflict_Tracker_API.repository;

import com.example.Conflict_Tracker_API.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    // Buscar un país por su código único
    Optional<Country> findByCode(String code);
}
