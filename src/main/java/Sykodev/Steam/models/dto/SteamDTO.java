package Sykodev.Steam.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SteamDTO {

    private long id;
    private String bibliotheque;
    private String monCompte;
    private String aide;
}
