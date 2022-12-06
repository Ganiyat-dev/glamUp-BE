package com.ghinaglam.ghinaglam.service;

import com.ghinaglam.ghinaglam.dto.MakeUpDto;

import java.util.List;

public interface MakeupService {
    List<MakeUpDto> getMakeupArtists();

    MakeUpDto getMakeupArtist(long id);

    MakeUpDto saveMakeupArtist(MakeUpDto makeUpDto) throws Exception;

    MakeUpDto updateMakeupArtist(long id, MakeUpDto makeUpDto);

    String deleteMakeupArtist(long id);


}
