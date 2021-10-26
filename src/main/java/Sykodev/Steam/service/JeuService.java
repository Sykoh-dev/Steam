package Sykodev.Steam.service;

import Sykodev.Steam.models.dto.JeuDTO;
import Sykodev.Steam.models.form.JeuForm;

import java.util.List;

public interface JeuService {

    List<JeuDTO> getAll();
    JeuDTO getOne(Long id);
    JeuDTO insert(JeuForm form);
    JeuDTO delete(Long id);
    JeuDTO update(Long id);
}
