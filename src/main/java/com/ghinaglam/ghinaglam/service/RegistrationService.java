package com.ghinaglam.ghinaglam.service;


import com.ghinaglam.ghinaglam.dto.AppUserDto;
import com.ghinaglam.ghinaglam.dto.RegistrationRequestDto;
import com.ghinaglam.ghinaglam.model.AppUser;

public interface RegistrationService {
    AppUser register(RegistrationRequestDto request);

    String confirmToken(String token);
}
