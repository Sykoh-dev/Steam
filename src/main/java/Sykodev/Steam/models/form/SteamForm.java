package Sykodev.Steam.models.form;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
public class SteamForm {



    @NotBlank
    private String bibliotheque;

    @NotBlank
    private String aide;

}
