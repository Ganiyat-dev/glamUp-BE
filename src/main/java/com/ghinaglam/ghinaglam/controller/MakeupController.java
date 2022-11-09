package com.ghinaglam.ghinaglam.controller;

import com.ghinaglam.ghinaglam.dto.MakeUpDto;
import com.ghinaglam.ghinaglam.model.BaseEntity;
import com.ghinaglam.ghinaglam.model.MakeupArtist;
import com.ghinaglam.ghinaglam.service.MakeupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MakeupController extends BaseEntity {
    private final MakeupService makeupService;

    @GetMapping("/muas")
    public ResponseEntity<List<MakeupArtist>> getMakeupArtists() {
        return ResponseEntity.ok().body(makeupService.getMakeupArtists());
    }

    @GetMapping("/mua/{email}")
    public ResponseEntity<MakeUpDto> getMakeUpArtist(@PathVariable("email") String email) {
        return ResponseEntity.ok().body(makeupService.getMakeupArtist(email));
    }

    @PostMapping("/mua")
    public ResponseEntity<MakeUpDto> saveMakeupArtist(@RequestBody MakeUpDto makeupDto) {
        return ResponseEntity.ok().body(makeupService.saveMakeupArtist(makeupDto));
    }

    @PatchMapping(value = "/mua/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MakeUpDto> updateMakeupArtist(@PathVariable("id") Long id, @RequestBody MakeUpDto makeUpArtist) {
        return ResponseEntity.ok().body(makeupService.updateMakeupArtist(id, makeUpArtist));
    }

    @DeleteMapping("/mua/{id}")
    public ResponseEntity<String> deleteMakeupArtist(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(makeupService.deleteMakeupArtist(id));
    }
}
