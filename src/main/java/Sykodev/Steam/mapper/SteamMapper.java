package Sykodev.Steam.mapper;

import Sykodev.Steam.models.dto.SteamDTO;
import Sykodev.Steam.models.entity.Steam;
import Sykodev.Steam.models.form.SteamForm;
import org.springframework.stereotype.Service;

@Service
public class SteamMapper {

    public SteamDTO toDTO(Steam entity){

        if( entity == null )
            return null;

        return SteamDTO.builder()

                .build();
    }

    public Steam formToEntity(SteamForm form){

        if( form == null )
            return null;

        Steam steam = new Steam();

        return steam;
    }
}
