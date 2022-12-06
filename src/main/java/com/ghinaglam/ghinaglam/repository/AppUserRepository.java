package com.ghinaglam.ghinaglam.repository;

import com.ghinaglam.ghinaglam.dto.AppUserDto;
import com.ghinaglam.ghinaglam.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);

    void deleteByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE users a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
}
