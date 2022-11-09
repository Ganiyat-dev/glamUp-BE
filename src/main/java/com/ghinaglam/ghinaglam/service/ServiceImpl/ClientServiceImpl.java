package com.ghinaglam.ghinaglam.service.ServiceImpl;

import com.ghinaglam.ghinaglam.dto.ClientDto;
import com.ghinaglam.ghinaglam.exception.ResourceNotFoundException;
import com.ghinaglam.ghinaglam.model.Client;
import com.ghinaglam.ghinaglam.repository.ClientRepository;
import com.ghinaglam.ghinaglam.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ClientDto getClient(String email) {
        if (clientRepository.existsByEmail(email)) {
            return mapToDto(clientRepository.findByEmail(email));
        }
        throw new ResourceNotFoundException("Client not found");
    }

    @Override
    public ClientDto saveClient(ClientDto clientDto) {
        Client client = mapToEntity(clientDto);
        if (clientRepository.existsByEmail(client.getEmail())) {
            throw new IllegalStateException("Email already exists");
        }
        return mapToDto(clientRepository.save(client));
    }

    @Transactional
    public ClientDto updateClient(Long id, ClientDto clientDto) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Client with the " + id + "does not exist"));
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setPhoneNumber(clientDto.getPhoneNumber());

        return mapToDto(clientRepository.save(client));
    }

    @Override
    public String deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return "User deleted!";
        }
        throw new IllegalStateException("User not found");
    }

    private ClientDto mapToDto(Client client) {
        return mapper.map(client, ClientDto.class);
    }

    private Client mapToEntity(ClientDto clientDto) {
        return mapper.map(clientDto, Client.class);
    }
}
