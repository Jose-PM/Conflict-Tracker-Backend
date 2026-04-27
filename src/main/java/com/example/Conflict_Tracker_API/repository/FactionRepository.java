package com.example.Conflict_Tracker_API.repository;

import com.example.Conflict_Tracker_API.model.Faction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactionRepository extends JpaRepository<Faction, Long> {
}