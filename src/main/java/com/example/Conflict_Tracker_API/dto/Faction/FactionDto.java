package com.example.Conflict_Tracker_API.dto.Faction;

import com.example.Conflict_Tracker_API.dto.Country.CountryDto;

import java.util.Set;


public class FactionDto {
    private Long id;
    private String name;
    private Long conflictId;
    private Set<CountryDto> supporters;


    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getConflictId() { return conflictId; }
    public void setConflictId(Long conflictId) { this.conflictId = conflictId; }
    public Set<CountryDto> getSupporters() { return supporters; }
    public void setSupporters(Set<CountryDto> supporters) { this.supporters = supporters; }
}