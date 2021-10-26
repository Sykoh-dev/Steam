package Sykodev.Steam.mapper;

import Sykodev.Steam.models.dto.AchatDTO;
import Sykodev.Steam.models.entity.Achat;
import Sykodev.Steam.models.form.AchatForm;
import org.springframework.stereotype.Service;

@Service
public class AchatMapper {

    public AchatDTO toDTO(Achat entity){

        if( entity == null )
            return null;

        return AchatDTO.builder()
                .id(entity.getId())
                .jeu(entity.getJeu())
                .prix(entity.getPrix())
                .build();

    }

    public Achat formToEntity(AchatForm form){

        if ( form == null )
            return null;

        Achat achat = new Achat();
        achat.setJeu(form.getJeu());
        achat.setAchat(form.getAchat());
        achat.setPrix(form.getPrix());

        return achat;

    }
}
