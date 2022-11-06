package com.ghinaglam.ghinaglam.service.ServiceImpl;

import com.ghinaglam.ghinaglam.dto.MakeUpDto;
import com.ghinaglam.ghinaglam.exception.ResourceNotFoundException;
import com.ghinaglam.ghinaglam.model.MakeupArtist;
import com.ghinaglam.ghinaglam.repository.MakeupRepository;
import com.ghinaglam.ghinaglam.service.MakeupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MakeupServiceImpl implements MakeupService {
    private final MakeupRepository makeupRepository;
    private final ModelMapper mapper = new ModelMapper();
    @Override
    public List<MakeupArtist> getMakeupArtists() {
        return makeupRepository.findAll();
    }
    @Override
    public MakeUpDto getMakeupArtist(String email) {
        if (makeupRepository.existsByEmail(email)) {
            return mapToDto(makeupRepository.findByEmail(email));
        }
        throw new ResourceNotFoundException("Makeup Artist not found");
    }

    @Override
    public MakeUpDto saveMakeupArtist(MakeUpDto makeUpDto) {
        MakeupArtist makeupArtist = mapToEntity(makeUpDto);
        if(makeupRepository.existsByEmail(makeupArtist.getEmail())) {
            throw new IllegalStateException("Email Already Exists");
        }
        return mapToDto(makeupRepository.save(makeupArtist));
    }
    @Transactional
    public MakeUpDto updateMakeupArtist(Long id, MakeUpDto makeUpDto) {
        MakeupArtist makeupArtist = makeupRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Makeup Professional with the" + id + " does not exist"));
        makeupArtist.setFirstName(makeUpDto.getFirstName());
        makeupArtist.setPhoneNumber(makeUpDto.getPhoneNumber());
        makeupArtist.setYearsOfExperience(makeUpDto.getYearsOfExperience());

        return mapToDto(makeupRepository.save(makeupArtist));
    }
    @Override
    public String deleteMakeupArtist(Long id) {
        if (makeupRepository.existsById(id)) {
            makeupRepository.deleteById(id);
            return "Artist deleted!";
        }
        throw new IllegalStateException("Makeup Artist not found!");
    }

    private MakeUpDto mapToDto(MakeupArtist makeupArtist) {
        return mapper.map(makeupArtist, MakeUpDto.class);
    }
    private MakeupArtist mapToEntity(MakeUpDto makeUpDto) {
        return mapper.map(makeUpDto, MakeupArtist.class);
    }
}
