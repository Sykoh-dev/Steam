package Sykodev.Steam.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class JeuDTO {

    private long id;
    private double prix;
    private double espaceDisque;
    private Date dateDeParution;
    private String editeur;
    private String evaluation;
}
