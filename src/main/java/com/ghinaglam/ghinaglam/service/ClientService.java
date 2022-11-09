package com.ghinaglam.ghinaglam.service;

import com.ghinaglam.ghinaglam.dto.ClientDto;
import com.ghinaglam.ghinaglam.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    ClientDto getClient(String email);

    ClientDto saveClient(ClientDto clientDto);

    ClientDto updateClient(Long id, ClientDto clientDto);

    String deleteClient(Long id);

//    ClientDto getClientById(Long id);
}
