package Sykodev.Steam.mapper;

import Sykodev.Steam.models.dto.ClientDTO;
import Sykodev.Steam.models.entity.Client;
import Sykodev.Steam.models.form.ClientForm;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {
    public ClientDTO toDTO(Client entity){

        if( entity == null )
            return null;

        return ClientDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .mail(entity.getMail())
                .adresse(entity.getAdresse())
                .build();

    }

    public Client formToEntity(ClientForm form){

        if ( form == null )
            return null;

        Client client = new Client();
        client.setNom(form.getNom());
        client.setPrenom(form.getPrenom());
        client.setMail(form.getMail());
        client.setAdresse(form.getAdresse());



        return client;

    }
}
