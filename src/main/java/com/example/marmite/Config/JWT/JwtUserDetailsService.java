package com.example.marmite.Config.JWT;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JwtUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(username.equalsIgnoreCase("matthieu")){
            //password au format BCRYPT
            return new User("matthieu",
                    "$2y$10$Iyilio1UnfqzBMCxFrz2x.oRgkxOI4v.bz8grZE8kxgfVq/7C8LcG",
                    new ArrayList<>());

        }
        else{
            throw new UsernameNotFoundException("Utilisateur introuvable");
        }
    }
}