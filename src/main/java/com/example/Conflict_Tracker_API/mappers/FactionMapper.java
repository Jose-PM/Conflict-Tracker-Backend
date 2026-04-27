package com.example.Conflict_Tracker_API.mappers;


import com.example.Conflict_Tracker_API.dto.Faction.FactionResponseDto;
import com.example.Conflict_Tracker_API.model.Faction;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class FactionMapper {


    private final CountryMapper countryMapper;


    public FactionMapper(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }


    public FactionResponseDto toDto(Faction f) {
        FactionResponseDto dto = new FactionResponseDto();
        dto.id = f.getId();
        dto.name = f.getName();
        dto.conflictId = f.getConflict().getId();
        dto.supportingCountries = f.getSupportingCountries().stream()
                .map(countryMapper::toDto)
                .collect(Collectors.toSet());
        return dto;
    }
}