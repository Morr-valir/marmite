package com.example.marmite.Config.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.marmite.Model.Utilisateur;
import com.example.marmite.Repository.UtilisateurRepository;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = utilisateurRepository.findById(username).orElse(null);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("Utilisateur introuvable");
        }
    }
}
