package com.example.marmite.Controller;

import java.util.Base64;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.marmite.Config.JWT.JwtTokenUtil;
import com.example.marmite.Model.Utilisateur;
import com.example.marmite.Repository.UtilisateurRepository;

@Controller
public class SecurityController {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping("/login")
    public ResponseEntity<String> createAuthenticationToken(@RequestHeader Map<String, String> header,
            @Value("jwt.secret") String secret)
            throws Exception {
        String username = getUsernameInRequestHeader(header);
        String password = getPasswordInRequestHeader(header);
        authenticate(username, password);
        Utilisateur utilisateur = utilisateurRepository.findById(username).orElse(null);
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        System.out.println(utilisateur);
        final String token = jwtTokenUtil.generateToken(utilisateur, secret);
        System.out.println(token);
        return ResponseEntity.ok(token);
        // return ResponseEntity.ok(username);
    }

    private String getUsernameInRequestHeader(Map<String, String> header) {
        String encodedUsernamePassword = header.get("authorization").split(" ")[1];
        String decodedUsernamePassword = new String(Base64.getDecoder().decode(encodedUsernamePassword));
        String username = decodedUsernamePassword.split(":")[0];
        return username;
    }

    private String getPasswordInRequestHeader(Map<String, String> header) {
        String encodedUsernamePassword = header.get("authorization").split(" ")[1];
        String decodedUsernamePassword = new String(Base64.getDecoder().decode(encodedUsernamePassword));
        String password = decodedUsernamePassword.split(":")[1];
        return password;
    }

    private void authenticate(String username, String password) throws Exception {
        // try {
        // authenticationManager.authenticate(new
        // UsernamePasswordAuthenticationToken(username, password));
        // } catch (DisabledException e) {
        // throw new Exception("USER_DISABLED", e);
        // } catch (BadCredentialsException e) {
        // throw new Exception("INVALID_CREDENTIALS", e);
        // }
        Utilisateur utilisateur = utilisateurRepository.findById(username).orElse(null);
        if (utilisateur != null && !utilisateur.getPassword().equals(password)) {
            throw new Exception("INVALID_CREDENTIALS");
        }
    }

}
