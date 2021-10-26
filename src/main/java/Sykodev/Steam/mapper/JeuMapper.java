package Sykodev.Steam.mapper;

import Sykodev.Steam.models.dto.JeuDTO;
import Sykodev.Steam.models.entity.Jeu;
import Sykodev.Steam.models.form.JeuForm;
import org.springframework.stereotype.Service;

@Service
public class JeuMapper {

    public JeuDTO toDTO(Jeu entity){

        if( entity == null )
            return null;

        return JeuDTO.builder()
                .prix(entity.getPrix())
                .espaceDisque(entity.getEspaceDisque())
                .dateDeParution(entity.getDateDeParution())
                .editeur(entity.getEditeur())
                .evaluation(entity.getEvaluation())


                .build();

    }

    public Jeu formToEntity(JeuForm form){

        if ( form == null )
            return null;

        Jeu jeu = new Jeu();
        jeu.setPrix(form.getPrix());
        jeu.setEspaceDisque(form.getEspaceDisque());
        jeu.setDateDeParution(form.getDateDeParution());
        jeu.setEditeur(form.getEditeur());
        jeu.setEvaluation(form.getEvaluation());

        return jeu;

    }
}
