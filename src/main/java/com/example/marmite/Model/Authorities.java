package com.example.marmite.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@IdClass(CleCompose.class)
public class Authorities {
    @Id
    @OneToOne
    @JoinColumn(name = "username")
    private Utilisateur utilisateur;

    @Id
    private String authority;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

class CleCompose implements Serializable {
    private Utilisateur utilisateur;
    private String authority;
}
