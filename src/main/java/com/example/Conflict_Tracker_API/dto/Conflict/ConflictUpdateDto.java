package com.example.Conflict_Tracker_API.dto.Conflict;

import java.time.LocalDate;
import java.util.Set;

public class ConflictUpdateDto {
    public String name;
    public LocalDate startDate;
    public String status;
    public String description;
    public Set<String> countryCodes;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Set<String> getCountryCodes() { return countryCodes; }
    public void setCountryCodes(Set<String> countryCodes) { this.countryCodes = countryCodes; }
}
