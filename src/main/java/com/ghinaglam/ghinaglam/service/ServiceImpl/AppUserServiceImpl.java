package com.ghinaglam.ghinaglam.service.ServiceImpl;

import com.ghinaglam.ghinaglam.dto.AppUserDto;
import com.ghinaglam.ghinaglam.model.AppUser;
import com.ghinaglam.ghinaglam.repository.AppUserRepository;
import com.ghinaglam.ghinaglam.service.AppUserService;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@Service
@EqualsAndHashCode
@AllArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    private final static String USER_NOT_FOUND_MSG = "User with the email %s not found";

    @Override
    public List<AppUser> getUsers() {
        log.info("Retrieving all users");
        return appUserRepository.findAll();
    }

//    @Override
//    public AppUser saveUser(AppUser appUser) {
//        log.info("Saving new user {} {} into the database", appUser.getFirst_name(), appUser.getLast_name());
//        Optional<AppUser> appUserOptional = appUserRepo.findByEmail(appUser.getEmail());
//        if (appUserOptional.isPresent()) {
//            throw new IllegalStateException("Email taken");
//        }
//        return appUserRepo.save(appUser);
//    }

    @Override
    public AppUser getUser(long userId) {
        log.info("Retrieving user {} from the database", userId);
        return appUserRepository.findById(userId).orElseThrow(()->
                new IllegalStateException("User does not exist"));
    }

    public String deleteUser(String email) {
        log.info("Deleting User with email " + email);
        Optional<AppUser> appUserOptional = appUserRepository.findByEmail(email);
        if (appUserOptional.isPresent()) {
            appUserRepository.deleteByEmail(email);
            return "User deleted";
        }
        throw new IllegalStateException("User is not present");
    }

    @Override
    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

//    @Override
//    public UserDetails loadUserByUsername(String email)
//            throws UsernameNotFoundException {
//        AppUser user = appUserRepository.findByEmail(email)
//                .orElseThrow(()-> new UsernameNotFoundException(
//                        String.format(USER_NOT_FOUND_MSG, email)));
//        return new org.springframework.security.core.userdetails.User(user.getEmail(),
//                user.getPassword(), mapRolesToAuthorities(user.getRoles()));
//    }

//    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Role role){
//        return Collections.singleton(new SimpleGrantedAuthority(role.toString()));
//    }

    @Override
    public AppUser signUpUser(AppUser appUser) {
        boolean userExist =  appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if (userExist){
            throw new IllegalStateException("Email already exists");
        }
        String encodedPassword = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        return appUserRepository.save(appUser);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
