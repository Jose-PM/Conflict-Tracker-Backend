package com.example.Conflict_Tracker_API.dto.Conflict;

import com.example.Conflict_Tracker_API.dto.Country.CountryDto;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ConflictResponseDto {

    private Long id;
    private String name;
    private LocalDate startDate;
    private String status;
    private String description;
    private Set<CountryDto> countries = new HashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Set<CountryDto> getCountries() { return countries; }
    public void setCountries(Set<CountryDto> countries) {
        if (countries != null) this.countries = countries;
    }
}
