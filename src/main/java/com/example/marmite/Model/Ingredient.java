package com.example.marmite.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String unite;
    private String quantite;

    public Ingredient() {
    }

    /**
     * @param id
     */
    public Ingredient(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    /**
     * @param i
     */
    public void setId(Long i) {
        this.id = i;
    }

    public String getNom() {
        return nom;
    }

    /**
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUnite() {
        return unite;
    }

    /**
     * @param unite
     */
    public void setUnite(String unite) {
        this.unite = unite;
    }

    public String getQuantite() {
        return quantite;
    }

    /**
     * @param quantite
     */
    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Ingredient [id=" + id + ", nom=" + nom + ", unite=" + unite + ", quantite=" + quantite + "]";
    }
}
