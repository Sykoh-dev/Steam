package Sykodev.Steam.service;

import Sykodev.Steam.exceptions.ElementAlreadyExistsException;
import Sykodev.Steam.exceptions.ElementNotFoundException;
import Sykodev.Steam.mapper.SteamMapper;
import Sykodev.Steam.models.dto.SteamDTO;
import Sykodev.Steam.models.entity.Steam;
import Sykodev.Steam.models.form.SteamForm;
import Sykodev.Steam.repository.SteamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SteamServiceImpl implements SteamService{

    private final SteamMapper mapper;
    private final SteamRepository  repository;

    public SteamServiceImpl(SteamMapper mapper, SteamRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }



    @Override
    public List<SteamDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SteamDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public SteamDTO insert(SteamForm form) {

        Steam toInsert = mapper.formToEntity(form);
        toInsert = repository.save(toInsert);
        return mapper.toDTO(toInsert);
    }

    @Override
    public SteamDTO delete(Long id) {
        Steam toDelete = repository.findById(id)
                .orElseThrow(ElementAlreadyExistsException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);
    }

    @Override
    public SteamDTO update(Long id) {
        return null;
    }
}
