package com.ghinaglam.ghinaglam.service;

import com.ghinaglam.ghinaglam.model.AppUser;


import java.util.List;

public interface AppUserService {
    List<AppUser> getUsers();

//    AppUser saveUser(AppUser appUser);

    AppUser signUpUser(AppUser appUser);

    AppUser getUser(long userId);

    String deleteUser(String email);

    int enableAppUser(String email);

}
