package com.example.Conflict_Tracker_API.mappers;

import com.example.Conflict_Tracker_API.dto.Conflict.ConflictCreateDto;
import com.example.Conflict_Tracker_API.dto.Conflict.ConflictResponseDto;
import com.example.Conflict_Tracker_API.dto.Conflict.ConflictUpdateDto;
import com.example.Conflict_Tracker_API.model.Conflict;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ConflictMapper {

    private final CountryMapper countryMapper;

    public ConflictMapper(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    // Entidad a DTO
    public ConflictResponseDto toDto(Conflict entity) {
        if (entity == null) return null;

        ConflictResponseDto dto = new ConflictResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStartDate(entity.getStartDate());
        dto.setStatus(entity.getStatus() != null ? entity.getStatus().name() : null);
        dto.setDescription(entity.getDescription());

        // Asociar países
        dto.setCountries(
                entity.getCountries() != null
                        ? entity.getCountries().stream()
                        .map(countryMapper::toDto)
                        .collect(Collectors.toSet())
                        : Set.of()
        );

        return dto;
    }

    // Actualizar entidad con DTO
    public void updateEntityFromDto(ConflictUpdateDto dto, Conflict entity) {
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getStartDate() != null) entity.setStartDate(dto.getStartDate());
        if (dto.getStatus() != null) entity.setStatus(Conflict.Status.valueOf(dto.getStatus().toUpperCase()));
        if (dto.getDescription() != null) entity.setDescription(dto.getDescription());
    }

    // Crear entidad desde DTO
    public Conflict toEntity(ConflictCreateDto dto) {
        Conflict conflict = new Conflict();
        conflict.setName(dto.getName());
        conflict.setStartDate(dto.getStartDate());
        if (dto.getStatus() != null) conflict.setStatus(Conflict.Status.valueOf(dto.getStatus().toUpperCase()));
        conflict.setDescription(dto.getDescription());
        return conflict;
    }
}
