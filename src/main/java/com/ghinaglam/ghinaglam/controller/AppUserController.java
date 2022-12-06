package com.ghinaglam.ghinaglam.controller;

import com.ghinaglam.ghinaglam.dto.AppUserDto;
import com.ghinaglam.ghinaglam.dto.RegistrationRequestDto;
import com.ghinaglam.ghinaglam.model.AppUser;
import com.ghinaglam.ghinaglam.service.AppUserService;
import com.ghinaglam.ghinaglam.service.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class AppUserController {
    private final AppUserService appUserService;
    private final RegistrationService registrationService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers() {
        return ResponseEntity.ok().body(appUserService.getUsers());
    }

//    @PostMapping("/user/save")
//    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser appUser) {
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
//        return ResponseEntity.created(uri).body(appUserService.saveUser(appUser));
//    }

    @PostMapping("/user/register")
    public AppUser signUpUser(@RequestBody RegistrationRequestDto request) {
        return registrationService.register(request);

    }

    @GetMapping("/user/register/confirm")
    public void confirm(@RequestParam("token") String token, HttpServletResponse httpServletResponse) {
        log.info("token received");
        registrationService.confirmToken(token);
        httpServletResponse.setHeader("Location", "http://localhost:3000/sign-in");
        httpServletResponse.setStatus(302);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<AppUser> getUser(@PathVariable("id") long userId) {
        return ResponseEntity.ok().body(appUserService.getUser(userId));
    }

    @DeleteMapping("/user/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable("email") String email) {
        return ResponseEntity.ok().body(appUserService.deleteUser(email));
    }


}
