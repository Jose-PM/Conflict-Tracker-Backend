package com.example.Conflict_Tracker_API.dto.Faction;

import java.util.Set;

public class FactionCreateDto {
    public String name;
    public Long conflictId;
    public Set<String> supportingCountryCodes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getConflictId() {
        return conflictId;
    }

    public void setConflictId(Long conflictId) {
        this.conflictId = conflictId;
    }

    public Set<String> getSupportingCountryCodes() {
        return supportingCountryCodes;
    }

    public void setSupportingCountryCodes(Set<String> supportingCountryCodes) {
        this.supportingCountryCodes = supportingCountryCodes;
    }
}
