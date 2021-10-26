package Sykodev.Steam.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AchatDTO {

    private long id;
    private String jeu;
    private Date achat;
    private double prix;
}
