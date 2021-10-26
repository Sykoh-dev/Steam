package Sykodev.Steam.service;

import Sykodev.Steam.models.dto.UtilisateurDTO;
import Sykodev.Steam.models.form.UtilisateurForm;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UtilisateurService extends UserDetailsService {

    UtilisateurDTO insert(UtilisateurForm form);
    UtilisateurDTO update(long id, UtilisateurForm form);
    List<UtilisateurDTO> getAll();

}