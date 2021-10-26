package Sykodev.Steam.service;

import Sykodev.Steam.exceptions.ElementAlreadyExistsException;
import Sykodev.Steam.exceptions.ElementNotFoundException;
import Sykodev.Steam.mapper.ClientMapper;
import Sykodev.Steam.models.dto.ClientDTO;
import Sykodev.Steam.models.entity.Client;
import Sykodev.Steam.models.form.ClientForm;
import Sykodev.Steam.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements  ClientService{

    private final ClientMapper mapper;
    private final ClientRepository repository;

    public ClientServiceImpl(ClientMapper mapper, ClientRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<ClientDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public ClientDTO insert(ClientForm form) {


        Client toInsert = mapper.formToEntity(form);
        toInsert = repository.save(toInsert);
        return mapper.toDTO(toInsert);
    }

    @Override
    public ClientDTO delete(Long id) {
        Client toDelete = repository.findById(id)
                .orElseThrow(ElementAlreadyExistsException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);
    }

    @Override
    public ClientDTO update(Long id) {
        return null;
    }
}
