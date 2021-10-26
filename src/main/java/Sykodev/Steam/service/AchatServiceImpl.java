package Sykodev.Steam.service;

import Sykodev.Steam.exceptions.ElementAlreadyExistsException;
import Sykodev.Steam.exceptions.ElementNotFoundException;
import Sykodev.Steam.mapper.AchatMapper;
import Sykodev.Steam.models.dto.AchatDTO;
import Sykodev.Steam.models.entity.Achat;
import Sykodev.Steam.models.form.AchatForm;
import Sykodev.Steam.repository.AchatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AchatServiceImpl implements AchatService {

    private final AchatMapper mapper;
    private final AchatRepository repository;

    public AchatServiceImpl(AchatMapper mapper, AchatRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<AchatDTO> getAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AchatDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public AchatDTO insert(AchatForm form) {


        Achat toInsert = mapper.formToEntity(form);
        toInsert = repository.save(toInsert);
        return mapper.toDTO(toInsert);

    }

    @Override
    public AchatDTO delete(Long id) {

        Achat toDelete = repository.findById(id)
                .orElseThrow(ElementAlreadyExistsException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);
    }

    @Override
    public AchatDTO update(Long id) {

        return null;
    }
}
