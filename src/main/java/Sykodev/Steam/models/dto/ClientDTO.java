package Sykodev.Steam.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {

    private long id;
    private String nom;
    private String prenom;
    private String mail;
    private String adresse;
}
