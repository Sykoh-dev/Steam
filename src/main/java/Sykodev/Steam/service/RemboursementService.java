package Sykodev.Steam.service;

import Sykodev.Steam.models.dto.RemboursementDTO;
import Sykodev.Steam.models.form.RemboursementForm;

import java.util.List;

public interface RemboursementService {

    List<RemboursementDTO> getAll();
    RemboursementDTO getOne(Long id);
    RemboursementDTO insert(RemboursementForm form);
    RemboursementDTO delete(Long id);
    RemboursementDTO update(Long id);
}
