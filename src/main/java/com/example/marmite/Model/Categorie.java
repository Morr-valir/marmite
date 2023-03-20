package com.example.marmite.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    
    @ManyToOne
    private Categorie categorieParent;
    public Categorie() {}
    public Categorie(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public Categorie getCategorieParent() {
        return categorieParent;
    }
    public void setCategorieParent(Categorie categorieParent) {
        this.categorieParent = categorieParent;
    }

}
