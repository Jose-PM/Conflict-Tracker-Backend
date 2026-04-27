package com.example.Conflict_Tracker_API.repository;

import com.example.Conflict_Tracker_API.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}