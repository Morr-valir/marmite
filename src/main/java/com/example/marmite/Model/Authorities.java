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

    /**
     * @return
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * @param utilisateur
     */
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     * @return
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * @param authority
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

class CleCompose implements Serializable {
    private Utilisateur utilisateur;
    private String authority;
}
