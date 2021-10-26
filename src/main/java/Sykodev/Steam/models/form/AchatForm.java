package Sykodev.Steam.models.form;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Validated
public class AchatForm {


    @NotBlank
    private String jeu;

    @NotNull
    private Date achat;

    @Min(0)
    private double prix;


}
