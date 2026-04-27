package com.example.Conflict_Tracker_API.repository;

import com.example.Conflict_Tracker_API.model.Conflict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConflictRepository extends JpaRepository<Conflict, Long> {

    // Buscar conflictos por estado
    List<Conflict> findByStatus(Conflict.Status status);

    // Buscar conflictos por código de país
    @Query("SELECT c FROM Conflict c JOIN c.countries co WHERE co.code = :code")
    List<Conflict> findByCountryCode(@Param("code") String code);
}
