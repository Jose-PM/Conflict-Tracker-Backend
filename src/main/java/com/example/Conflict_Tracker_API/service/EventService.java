package com.example.Conflict_Tracker_API.service;

import com.example.Conflict_Tracker_API.dto.Event.EventCreateDto;
import com.example.Conflict_Tracker_API.dto.Event.EventResponseDto;
import com.example.Conflict_Tracker_API.dto.Event.EventUpdateDto;

import java.util.List;

public interface EventService {
    List<EventResponseDto> getAll();
    EventResponseDto getById(Long id);
    EventResponseDto create(EventCreateDto dto);
    EventResponseDto update(Long id, EventUpdateDto dto);
    void delete(Long id);
}
