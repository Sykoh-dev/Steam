package Sykodev.Steam.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RemboursementDTO {

    private long id;
    private String jeu;
    private double prix;
}
