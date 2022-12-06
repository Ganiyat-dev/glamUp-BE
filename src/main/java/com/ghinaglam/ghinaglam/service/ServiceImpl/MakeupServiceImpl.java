package com.ghinaglam.ghinaglam.service.ServiceImpl;

import com.ghinaglam.ghinaglam.dto.MakeUpDto;
import com.ghinaglam.ghinaglam.dto.RegistrationRequestDto;
import com.ghinaglam.ghinaglam.model.AppUser;
import com.ghinaglam.ghinaglam.model.MakeupArtist;
import com.ghinaglam.ghinaglam.repository.MakeupRepository;
import com.ghinaglam.ghinaglam.service.MakeupService;
import com.ghinaglam.ghinaglam.service.RegistrationService;
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
    private final RegistrationService registrationService;

    //    @Override
//    public List<MakeupArtist> getMakeupArtists() {
//        return makeupRepository.findAll();
//    }
    @Override
    public List<MakeUpDto> getMakeupArtists() {
        return makeupRepository.findAll().stream().map(this::mapToDto).toList();
    }


    @Override
    public MakeUpDto getMakeupArtist(long id) {
        return mapToDto(makeupRepository.findById(id).orElseThrow(()-> new IllegalStateException("MakeUp Artist with the id doest not exist")));

    }

    @Override
    public MakeUpDto saveMakeupArtist(MakeUpDto makeUpDto) throws Exception {
        AppUser appUser = registrationService.register(new RegistrationRequestDto(
                makeUpDto.getFirstName(), makeUpDto.getLastName(),
                makeUpDto.getEmail(), makeUpDto.getPhoneNumber(),
                makeUpDto.getPassword(), makeUpDto.getRoles()));
        MakeupArtist makeupArtist = mapToEntity(makeUpDto);
        makeupArtist.setAppUser(appUser);
        makeupArtist.setSpecialization(makeUpDto.getSpecialization());
        makeupArtist.setYearsOfExperience(makeUpDto.getYearsOfExperience());

//        MakeupArtist makeupArtist = mapToEntity(makeUpDto);
//        makeupArtist.setAppUser(currentUser);
//        if (makeupRepository.existsByEmail(makeupArtist.getEmail())) {
//            throw new IllegalStateException("Email Already Exists");
//        }
        return mapToDto(makeupRepository.save(makeupArtist));

    }

    @Transactional
    public MakeUpDto updateMakeupArtist(long id, MakeUpDto makeUpDto) {
        MakeupArtist makeupArtist = makeupRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Makeup Professional with the" + id + " does not exist"));
        makeupArtist.setSpecialization(makeUpDto.getSpecialization());
        makeupArtist.setYearsOfExperience(makeUpDto.getYearsOfExperience());

        return mapToDto(makeupRepository.save(makeupArtist));
    }

    @Override
    public String deleteMakeupArtist(long id) {
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
