package com.example.Conflict_Tracker_API.service;

import com.example.Conflict_Tracker_API.dto.Event.EventCreateDto;
import com.example.Conflict_Tracker_API.dto.Event.EventResponseDto;
import com.example.Conflict_Tracker_API.dto.Event.EventUpdateDto;
import com.example.Conflict_Tracker_API.exception.ResourceNotFoundException;
import com.example.Conflict_Tracker_API.mappers.EventMapper;
import com.example.Conflict_Tracker_API.model.Event;
import com.example.Conflict_Tracker_API.model.Conflict;
import com.example.Conflict_Tracker_API.repository.EventRepository;
import com.example.Conflict_Tracker_API.repository.ConflictRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final ConflictRepository conflictRepository;
    private final EventMapper eventMapper;

    public EventServiceImpl(EventRepository eventRepository,
                            ConflictRepository conflictRepository,
                            EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.conflictRepository = conflictRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public List<EventResponseDto> getAll() {
        return eventRepository.findAll()
                .stream()
                .map(eventMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventResponseDto getById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        return eventMapper.toResponseDto(event);
    }

    @Override
    public EventResponseDto create(EventCreateDto dto) {
        Event event = new Event();
        event.setEventDate(dto.getEventDate());
        event.setLocation(dto.getLocation());
        event.setDescription(dto.getDescription());

        Conflict conflict = conflictRepository.findById(dto.getConflictId())
                .orElseThrow(() -> new ResourceNotFoundException("Conflict not found"));
        event.setConflict(conflict);

        return eventMapper.toResponseDto(eventRepository.save(event));
    }

    @Override
    public EventResponseDto update(Long id, EventUpdateDto dto) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        if (dto.getEventDate() != null) event.setEventDate(dto.getEventDate());
        if (dto.getLocation() != null) event.setLocation(dto.getLocation());
        if (dto.getDescription() != null) event.setDescription(dto.getDescription());
        if (dto.getConflictId() != null) {
            Conflict conflict = conflictRepository.findById(dto.getConflictId())
                    .orElseThrow(() -> new ResourceNotFoundException("Conflict not found"));
            event.setConflict(conflict);
        }

        return eventMapper.toResponseDto(eventRepository.save(event));
    }

    @Override
    public void delete(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new ResourceNotFoundException("Event not found");
        }
        eventRepository.deleteById(id);
    }
}
