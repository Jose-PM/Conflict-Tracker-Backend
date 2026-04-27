package com.example.Conflict_Tracker_API.service;

import com.example.Conflict_Tracker_API.dto.Conflict.ConflictCreateDto;
import com.example.Conflict_Tracker_API.dto.Conflict.ConflictResponseDto;
import com.example.Conflict_Tracker_API.dto.Conflict.ConflictUpdateDto;

import java.util.List;

public interface ConflictService {
    List<ConflictResponseDto> getAll();
    ConflictResponseDto getById(Long id);
    ConflictResponseDto create(ConflictCreateDto dto);
    ConflictResponseDto update(Long id, ConflictUpdateDto dto);
    void delete(Long id);
    List<ConflictResponseDto> findByStatus(String status);
    List<ConflictResponseDto> findByCountryCode(String countryCode); // <- debe coincidir
}
