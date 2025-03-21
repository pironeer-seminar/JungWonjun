package Pironeer.Assignment2.controller;

import Pironeer.Assignment2.dto.SentenceRequestDto;
import Pironeer.Assignment2.dto.SentenceResponseDto;
import Pironeer.Assignment2.service.SentenceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analyze")
public class SentenceController {
    private final SentenceService service;

    public SentenceController(SentenceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SentenceResponseDto> getResult(@Valid @RequestBody SentenceRequestDto request) {
        SentenceResponseDto result = service.getResult(request);
        return ResponseEntity.ok(result);
    }
}
