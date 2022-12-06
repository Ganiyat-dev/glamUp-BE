package com.ghinaglam.ghinaglam.controller;

import com.ghinaglam.ghinaglam.dto.LoginDto;
import com.ghinaglam.ghinaglam.dto.UserResponse;
import com.ghinaglam.ghinaglam.model.AppUser;
import com.ghinaglam.ghinaglam.repository.AppUserRepository;
import com.ghinaglam.ghinaglam.repository.ClientRepository;
import com.ghinaglam.ghinaglam.security.config.JwtTokenProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    private AuthenticationManager authenticationManager;

    private AppUserRepository appUserRepository;

    private ClientRepository clientRepository;


    private JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<UserResponse> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String currentUsername =  SecurityContextHolder.getContext().getAuthentication().getName();
        AppUser appUser = appUserRepository.findByEmail(currentUsername).orElseThrow(()-> new IllegalStateException("No user found"));
        String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new UserResponse(token, appUser));
    }
}
