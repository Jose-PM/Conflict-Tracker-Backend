package com.example.Conflict_Tracker_API.mappers;

import com.example.Conflict_Tracker_API.dto.Event.EventResponseDto;
import com.example.Conflict_Tracker_API.model.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    // Convierte entidad Event a EventResponseDto
    public EventResponseDto toResponseDto(Event e) {
        if (e == null) return null;

        EventResponseDto dto = new EventResponseDto();
        dto.setId(e.getId());
        dto.setEventDate(e.getEventDate());
        dto.setLocation(e.getLocation());
        dto.setDescription(e.getDescription());
        dto.setConflictId(e.getConflict() != null ? e.getConflict().getId() : null);

        return dto;
    }
}
