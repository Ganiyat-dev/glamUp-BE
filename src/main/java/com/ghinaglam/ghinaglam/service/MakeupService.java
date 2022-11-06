package com.ghinaglam.ghinaglam.service;

import com.ghinaglam.ghinaglam.dto.MakeUpDto;
import com.ghinaglam.ghinaglam.model.MakeupArtist;

import java.util.List;

public interface MakeupService {
    List<MakeupArtist> getMakeupArtists();

    MakeUpDto getMakeupArtist(String email);

    MakeUpDto saveMakeupArtist(MakeUpDto makeUpDto);

    MakeUpDto updateMakeupArtist(Long id, MakeUpDto makeUpDto);

    String deleteMakeupArtist(Long id);
}
