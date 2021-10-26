package Sykodev.Steam.service;

import Sykodev.Steam.exceptions.ElementAlreadyExistsException;
import Sykodev.Steam.exceptions.ElementNotFoundException;
import Sykodev.Steam.mapper.JeuMapper;
import Sykodev.Steam.models.dto.JeuDTO;
import Sykodev.Steam.models.entity.Jeu;
import Sykodev.Steam.models.form.JeuForm;
import Sykodev.Steam.repository.JeuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JeuServiceImpl implements  JeuService{

    private final JeuMapper mapper;
    private final JeuRepository repository;

    public JeuServiceImpl(JeuMapper mapper, JeuRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<JeuDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JeuDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public JeuDTO insert(JeuForm form) {

        Jeu toInsert = mapper.formToEntity(form);
        toInsert = repository.save(toInsert);
        return mapper.toDTO(toInsert);
    }

    @Override
    public JeuDTO delete(Long id) {
        Jeu toDelete = repository.findById(id)
                .orElseThrow(ElementAlreadyExistsException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);
    }

    @Override
    public JeuDTO update(Long id) {
        return null;
    }
}
