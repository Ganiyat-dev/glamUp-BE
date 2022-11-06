package com.ghinaglam.ghinaglam.repository;

import com.ghinaglam.ghinaglam.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
//    void deleteById(Long id);
    boolean existsByEmail(String email);
//    boolean existsById(Long id);
}