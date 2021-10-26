package Sykodev.Steam.mapper;

import Sykodev.Steam.models.dto.RemboursementDTO;
import Sykodev.Steam.models.entity.Remboursement;
import Sykodev.Steam.models.form.RemboursementForm;
import org.springframework.stereotype.Service;

@Service
public class RemboursementMapper {

    public RemboursementDTO toDTO(Remboursement entity){

        if( entity == null )
            return null;

        return RemboursementDTO.builder()
                .id(entity.getId())
                .jeu(entity.getJeu())
                .prix(entity.getPrix())
                .build();

    }

    public Remboursement formToEntity(RemboursementForm form){

        if ( form == null )
            return null;

        Remboursement remboursement= new Remboursement();
        remboursement.setJeu(form.getJeu());
        remboursement.setAchat(form.getAchat());
        remboursement.setPrix(form.getPrix());

        return remboursement;

    }
}
