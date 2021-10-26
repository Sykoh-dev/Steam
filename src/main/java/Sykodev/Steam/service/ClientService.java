package Sykodev.Steam.service;

import Sykodev.Steam.models.dto.ClientDTO;
import Sykodev.Steam.models.form.ClientForm;

import java.util.List;

public interface ClientService {

    List<ClientDTO> getAll();
    ClientDTO getOne(Long id);
    ClientDTO insert(ClientForm form);
    ClientDTO delete(Long id);
    ClientDTO update(Long id);
}
