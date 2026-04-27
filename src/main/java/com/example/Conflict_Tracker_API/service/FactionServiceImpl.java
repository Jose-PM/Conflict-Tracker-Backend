package com.example.Conflict_Tracker_API.service;

import com.example.Conflict_Tracker_API.dto.Conflict.*;
import com.example.Conflict_Tracker_API.dto.Faction.*;
import com.example.Conflict_Tracker_API.dto.Event.*;
import com.example.Conflict_Tracker_API.exception.ResourceNotFoundException;
import com.example.Conflict_Tracker_API.mappers.FactionMapper;
import com.example.Conflict_Tracker_API.model.*;
import com.example.Conflict_Tracker_API.repository.*;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
class FactionServiceImpl implements FactionService {


    private final FactionRepository factionRepository;
    private final ConflictRepository conflictRepository;
    private final CountryRepository countryRepository;
    private final FactionMapper factionMapper;


    public FactionServiceImpl(FactionRepository factionRepository, ConflictRepository conflictRepository, CountryRepository countryRepository, FactionMapper factionMapper) {
        this.factionRepository = factionRepository;
        this.conflictRepository = conflictRepository;
        this.countryRepository = countryRepository;
        this.factionMapper = factionMapper;
    }


    @Override
    public List<FactionResponseDto> getAll() {
        return factionRepository.findAll().stream().map(factionMapper::toDto).collect(Collectors.toList());
    }


    @Override
    public FactionResponseDto getById(Long id) {
        return factionMapper.toDto(factionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Faction not found")));
    }


    @Override
    public FactionResponseDto create(FactionCreateDto dto) {
        Conflict conflict = conflictRepository.findById(dto.conflictId).orElseThrow(() -> new ResourceNotFoundException("Conflict not found"));
        Faction faction = new Faction();
        faction.setName(dto.name);
        faction.setConflict(conflict);
        Set<Country> supporters = dto.supportingCountryCodes.stream()
                .map(code -> countryRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Country not found: " + code)))
                .collect(Collectors.toSet());
        faction.setSupportingCountries(supporters);
        return factionMapper.toDto(factionRepository.save(faction));
    }


    @Override
    public FactionResponseDto update(Long id, FactionUpdateDto dto) {
        Faction faction = factionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Faction not found"));
        if(dto.name != null) faction.setName(dto.name);
        if(dto.conflictId != null){
            Conflict conflict = conflictRepository.findById(dto.conflictId).orElseThrow(() -> new ResourceNotFoundException("Conflict not found"));
            faction.setConflict(conflict);
        }
        if(dto.supportingCountryCodes != null){
            Set<Country> supporters = dto.supportingCountryCodes.stream()
                    .map(code -> countryRepository.findByCode(code).orElseThrow(() -> new ResourceNotFoundException("Country not found: " + code)))
                    .collect(Collectors.toSet());
            faction.setSupportingCountries(supporters);
        }
        return factionMapper.toDto(factionRepository.save(faction));
    }


    @Override
    public void delete(Long id) {
        if(!factionRepository.existsById(id)) throw new ResourceNotFoundException("Faction not found");
        factionRepository.deleteById(id);
    }
}