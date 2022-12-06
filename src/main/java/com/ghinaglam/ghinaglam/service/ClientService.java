package com.ghinaglam.ghinaglam.service;

import com.ghinaglam.ghinaglam.dto.ClientDto;

import java.util.List;

public interface ClientService {
    List<ClientDto> getAllClients();

    ClientDto getClient(long id);

    ClientDto saveClient(ClientDto clientDto)throws Exception;

    ClientDto updateClient(long id, ClientDto clientDto);

    String deleteClient(long id);

//    ClientDto getClientById(Long id);
}
