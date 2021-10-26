package Sykodev.Steam.service;

import Sykodev.Steam.models.dto.AchatDTO;
import Sykodev.Steam.models.form.AchatForm;


import java.util.List;

public interface AchatService {

    List<AchatDTO> getAll();
    AchatDTO getOne(Long id);
    AchatDTO insert(AchatForm form);
    AchatDTO delete(Long id);
    AchatDTO update(Long id);
}
