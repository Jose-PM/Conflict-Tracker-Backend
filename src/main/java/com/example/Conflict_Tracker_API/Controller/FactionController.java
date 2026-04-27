package com.example.Conflict_Tracker_API.Controller;

import com.example.Conflict_Tracker_API.dto.Faction.FactionCreateDto;
import com.example.Conflict_Tracker_API.dto.Faction.FactionResponseDto;
import com.example.Conflict_Tracker_API.dto.Faction.FactionUpdateDto;
import com.example.Conflict_Tracker_API.service.FactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/factions")
public class FactionController {

    private final FactionService factionService;

    public FactionController(FactionService factionService) {
        this.factionService = factionService;
    }

    @GetMapping
    public ResponseEntity<List<FactionResponseDto>> getAll() {
        return ResponseEntity.ok(factionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FactionResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(factionService.getById(id));
    }

    @PostMapping
    public ResponseEntity<FactionResponseDto> create(@RequestBody FactionCreateDto dto) {
        return new ResponseEntity<>(factionService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FactionResponseDto> update(@PathVariable Long id, @RequestBody FactionUpdateDto dto) {
        return ResponseEntity.ok(factionService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        factionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
