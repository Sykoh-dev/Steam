package Sykodev.Steam.models.form;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Validated
public class JeuForm {


    @Min(0)
    private double prix;

    @Min(0) @Max(150)
    private double espaceDisque;


    private Date dateDeParution;

    @NotBlank
    private String editeur;

    @NotBlank
    private String evaluation;
}
