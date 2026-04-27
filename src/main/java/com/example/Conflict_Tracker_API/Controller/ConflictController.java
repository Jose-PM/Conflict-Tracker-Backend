package com.example.Conflict_Tracker_API.Controller;

import com.example.Conflict_Tracker_API.dto.Conflict.ConflictCreateDto;
import com.example.Conflict_Tracker_API.dto.Conflict.ConflictResponseDto;
import com.example.Conflict_Tracker_API.dto.Conflict.ConflictUpdateDto;
import com.example.Conflict_Tracker_API.service.ConflictService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conflicts")
public class ConflictController {

    private final ConflictService conflictService;

    public ConflictController(ConflictService conflictService) {
        this.conflictService = conflictService;
    }

    @GetMapping
    public ResponseEntity<List<ConflictResponseDto>> getAll(@RequestParam(required = false) String status) {
        if (status != null) {
            return ResponseEntity.ok(conflictService.findByStatus(status));
        }
        return ResponseEntity.ok(conflictService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConflictResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(conflictService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ConflictResponseDto> create(@RequestBody ConflictCreateDto dto) {
        return new ResponseEntity<>(conflictService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConflictResponseDto> update(@PathVariable Long id, @RequestBody ConflictUpdateDto dto) {
        return ResponseEntity.ok(conflictService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        conflictService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/country/{code}")
    public ResponseEntity<List<ConflictResponseDto>> getByCountryCode(@PathVariable String code) {
        return ResponseEntity.ok(conflictService.findByCountryCode(code));
    }
}
