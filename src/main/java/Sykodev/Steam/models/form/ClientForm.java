package Sykodev.Steam.models.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Validated
public class ClientForm {


    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @NotBlank
    private String mail;

    @NotBlank
    private String adresse;


}
