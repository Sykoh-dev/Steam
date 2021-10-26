package Sykodev.Steam.Util;

import Sykodev.Steam.models.entity.Utilisateur;
import Sykodev.Steam.repository.UtilisateurRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataFiller implements InitializingBean {



    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder encoder;

    public DataFiller(UtilisateurRepository utilisateurRepository, PasswordEncoder encoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.encoder = encoder;
    }





    @Override
    public void afterPropertiesSet() throws Exception {
        Utilisateur u = new Utilisateur();
        Utilisateur u1 = new Utilisateur();
        u.setUsername("user");
        u.setPassword(encoder.encode("pass"));
        u.setRoles(List.of("ADMIN"));
        utilisateurRepository.save(u);
        u1.setUsername("user1");
        u1.setPassword(encoder.encode("pass"));
        u1.setRoles(List.of("USER"));
        utilisateurRepository.save(u1);


    }


}
