package com.ghinaglam.ghinaglam.repository;

import com.ghinaglam.ghinaglam.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByAppUser_Id(long id);

}