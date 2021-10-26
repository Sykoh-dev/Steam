package Sykodev.Steam.models.form;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Validated
public class RemboursementForm {



    @NotBlank
    private String jeu;


    private Date achat;

    @Min(0)
    private double prix;
}
