package com.example.Conflict_Tracker_API.service;

import com.example.Conflict_Tracker_API.dto.Faction.FactionCreateDto;
import com.example.Conflict_Tracker_API.dto.Faction.FactionResponseDto;
import com.example.Conflict_Tracker_API.dto.Faction.FactionUpdateDto;

import java.util.List;

public interface FactionService {
    List<FactionResponseDto> getAll();
    FactionResponseDto getById(Long id);
    FactionResponseDto create(FactionCreateDto dto);
    FactionResponseDto update(Long id, FactionUpdateDto dto);
    void delete(Long id);
}