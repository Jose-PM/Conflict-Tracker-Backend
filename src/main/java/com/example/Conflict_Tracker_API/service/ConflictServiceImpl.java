package com.example.Conflict_Tracker_API.service;

import com.example.Conflict_Tracker_API.dto.Conflict.ConflictCreateDto;
import com.example.Conflict_Tracker_API.dto.Conflict.ConflictResponseDto;
import com.example.Conflict_Tracker_API.dto.Conflict.ConflictUpdateDto;
import com.example.Conflict_Tracker_API.mappers.ConflictMapper;
import com.example.Conflict_Tracker_API.model.Conflict;
import com.example.Conflict_Tracker_API.model.Country;
import com.example.Conflict_Tracker_API.repository.ConflictRepository;
import com.example.Conflict_Tracker_API.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ConflictServiceImpl implements ConflictService {

    private final ConflictRepository conflictRepo;
    private final CountryRepository countryRepo;
    private final ConflictMapper conflictMapper;

    public ConflictServiceImpl(ConflictRepository conflictRepo,
                               CountryRepository countryRepo,
                               ConflictMapper conflictMapper) {
        this.conflictRepo = conflictRepo;
        this.countryRepo = countryRepo;
        this.conflictMapper = conflictMapper;
    }

    @Override
    public List<ConflictResponseDto> getAll() {
        return conflictRepo.findAll().stream()
                .map(conflictMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ConflictResponseDto getById(Long id) {
        Conflict conflict = conflictRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Conflict not found"));
        return conflictMapper.toDto(conflict);
    }

    @Override
    public ConflictResponseDto create(ConflictCreateDto dto) {
        Conflict conflict = conflictMapper.toEntity(dto);

        // Asociar países
        if (dto.getCountryCodes() != null) {
            Set<Country> countries = dto.getCountryCodes().stream()
                    .map(code -> countryRepo.findByCode(code)
                            .orElseThrow(() -> new RuntimeException("Country not found: " + code)))
                    .collect(Collectors.toSet());
            conflict.setCountries(countries);
        }

        conflictRepo.save(conflict);
        return conflictMapper.toDto(conflict);
    }

    @Override
    public ConflictResponseDto update(Long id, ConflictUpdateDto dto) {
        Conflict conflict = conflictRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Conflict not found"));

        conflictMapper.updateEntityFromDto(dto, conflict);

        // Actualizar países si se pasan en DTO
        if (dto.getCountryCodes() != null) {
            Set<Country> countries = dto.getCountryCodes().stream()
                    .map(code -> countryRepo.findByCode(code)
                            .orElseThrow(() -> new RuntimeException("Country not found: " + code)))
                    .collect(Collectors.toSet());
            conflict.setCountries(countries);
        }

        conflictRepo.save(conflict);
        return conflictMapper.toDto(conflict);
    }

    @Override
    public void delete(Long id) {
        conflictRepo.deleteById(id);
    }

    @Override
    public List<ConflictResponseDto> findByStatus(String status) {
        return conflictRepo.findByStatus(Conflict.Status.valueOf(status.toUpperCase()))
                .stream()
                .map(conflictMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConflictResponseDto> findByCountryCode(String countryCode) {
        return conflictRepo.findByCountryCode(countryCode)
                .stream()
                .map(conflictMapper::toDto)
                .collect(Collectors.toList());
    }
}
