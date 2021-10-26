package Sykodev.Steam.service;

import Sykodev.Steam.exceptions.ElementAlreadyExistsException;
import Sykodev.Steam.exceptions.ElementNotFoundException;
import Sykodev.Steam.mapper.RemboursementMapper;
import Sykodev.Steam.models.dto.RemboursementDTO;
import Sykodev.Steam.models.entity.Remboursement;
import Sykodev.Steam.models.form.RemboursementForm;
import Sykodev.Steam.repository.RemboursementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RemboursementServiceImpl implements RemboursementService{

    private final RemboursementMapper mapper;
    private final RemboursementRepository repository;

    public RemboursementServiceImpl(RemboursementMapper mapper, RemboursementRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<RemboursementDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RemboursementDTO getOne(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public RemboursementDTO insert(RemboursementForm form) {


        Remboursement toInsert = mapper.formToEntity(form);
        toInsert = repository.save(toInsert);
        return mapper.toDTO(toInsert);
    }

    @Override
    public RemboursementDTO delete(Long id) {
        Remboursement toDelete = repository.findById(id)
                .orElseThrow(ElementAlreadyExistsException::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);
    }

    @Override
    public RemboursementDTO update(Long id) {
        return null;
    }
}
