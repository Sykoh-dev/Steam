package Sykodev.Steam.service;

import Sykodev.Steam.models.dto.SteamDTO;
import Sykodev.Steam.models.form.SteamForm;

import java.util.List;

public interface SteamService {

    List<SteamDTO> getAll();
    SteamDTO getOne(Long id);
    SteamDTO insert(SteamForm form);
    SteamDTO delete(Long id);
    SteamDTO update(Long id);
}
