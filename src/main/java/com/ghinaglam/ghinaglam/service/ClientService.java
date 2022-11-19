package com.ghinaglam.ghinaglam.service;

import com.ghinaglam.ghinaglam.dto.ClientDto;
import com.ghinaglam.ghinaglam.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<ClientDto> getAllClients();

    ClientDto getClient(String email);

    ClientDto saveClient(ClientDto clientDto);

    ClientDto updateClient(Long id, ClientDto clientDto);

    String deleteClient(Long id);

//    ClientDto getClientById(Long id);
}
