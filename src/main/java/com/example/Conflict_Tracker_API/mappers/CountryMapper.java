package com.example.Conflict_Tracker_API.mappers;

import com.example.Conflict_Tracker_API.dto.Country.CountryDto;
import com.example.Conflict_Tracker_API.model.Country;
import org.springframework.stereotype.Component;


@Component
public class CountryMapper {
    public CountryDto toDto(Country country) {
        if (country == null) return null;
        CountryDto dto = new CountryDto();
        dto.setId(country.getId());
        dto.setName(country.getName());
        dto.setCode(country.getCode());
        return dto;
    }
}