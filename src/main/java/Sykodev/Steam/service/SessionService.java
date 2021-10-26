package Sykodev.Steam.service;

import Sykodev.Steam.models.entity.Utilisateur;
import Sykodev.Steam.models.form.LoginForm;
import Sykodev.Steam.models.security.JwtProvider;
import Sykodev.Steam.repository.UtilisateurRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private final UtilisateurRepository uRep;
    private final AuthenticationManager auth;
    private final JwtProvider jwtProvider;

    public SessionService(UtilisateurRepository uRep, AuthenticationManager auth, JwtProvider jwtProvider) {
        this.uRep = uRep;
        this.auth = auth;
        this.jwtProvider = jwtProvider;
    }

    public String login(LoginForm form){

        Utilisateur user = uRep.findByUsername(form.getUsername())
                .orElseThrow( () -> new UsernameNotFoundException("l'utilisateur n'existe pas"));
        // creer l'authentication
        Authentication authentication = new UsernamePasswordAuthenticationToken(form.getUsername(),form.getPassword());
        // tester l'authentication
        auth.authenticate( authentication );

        // -> ok : creer token et le renvoyer
        return jwtProvider.createToken(user.getUsername(), user.getRoles());

    }
}
