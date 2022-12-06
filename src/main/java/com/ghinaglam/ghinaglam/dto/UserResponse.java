package com.ghinaglam.ghinaglam.dto;

import com.ghinaglam.ghinaglam.model.AppUser;
import com.ghinaglam.ghinaglam.model.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@Getter
@Setter
public class UserResponse
{
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Role roles;
    private AppUser appUser;
    private String accessToken;
    private String tokenType = "Bearer";

    public UserResponse(String accessToken, AppUser appUser) {
        this.accessToken = accessToken;
        this.appUser = appUser;
    }
}
