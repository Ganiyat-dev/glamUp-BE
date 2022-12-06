package com.ghinaglam.ghinaglam.service.ServiceImpl;

import com.ghinaglam.ghinaglam.dto.ClientDto;
import com.ghinaglam.ghinaglam.dto.RegistrationRequestDto;
import com.ghinaglam.ghinaglam.model.AppUser;
import com.ghinaglam.ghinaglam.model.Client;
import com.ghinaglam.ghinaglam.repository.ClientRepository;
import com.ghinaglam.ghinaglam.service.ClientService;
import com.ghinaglam.ghinaglam.service.RegistrationService;
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
    private final RegistrationService registrationService;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream().map(this::mapToDto).toList();
    }

    @Override
    public ClientDto getClient(long clientId) {
//        if (clientRepository.existsById(id)) {
//            return mapToDto(clientRepository.findById(id));
//        }
//        throw new ResourceNotFoundException("Client not found");
        log.info("Get Client with this id {}", clientId);
        return mapToDto(clientRepository.findById(clientId).orElseThrow(()-> new IllegalStateException("Client with the id doest not exist")));

    }

    @Override
    public ClientDto saveClient(ClientDto clientDto) throws Exception{
        AppUser appUser = registrationService.register(new RegistrationRequestDto(
                clientDto.getFirstName(), clientDto.getLastName(), clientDto.getEmail(),
                clientDto.getPhoneNumber(), clientDto.getPassword(),
                clientDto.getRoles()));
        Client client = mapToEntity(clientDto);
        client.setAppUser(appUser);
        return mapToDto(clientRepository.save(client));
    }

    @Transactional
    public ClientDto updateClient(long id, ClientDto clientDto) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Client with the " + id + "does not exist"));
        client.setStreetAddress(clientDto.getStreetAddress());
        client.setCity(clientDto.getCity());
        client.setState(clientDto.getState());

        return mapToDto(clientRepository.save(client));
    }

    @Override
    public String deleteClient(long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return "User deleted!";
        }
        throw new IllegalStateException("User not found");
    }

    private ClientDto mapToDto(Client client) {
        String[] address = client.getAddress().split("\n");
        client.setStreetAddress(address[0]);
        client.setCity(address[1]);
        client.setState(address[2]);
        return mapper.map(client, ClientDto.class);
    }

    private Client mapToEntity(ClientDto clientDto) {
        String address = clientDto.getStreetAddress() + "\n" + clientDto.getCity() + "\n" +
                clientDto.getState();
        clientDto.setAddress(address);
        return mapper.map(clientDto, Client.class);
    }
}

