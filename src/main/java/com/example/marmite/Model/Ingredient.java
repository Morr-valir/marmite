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

    // @ManyToMany
    // private List<Plat> plats;

    public Ingredient() {}
    public Ingredient(Long id) {
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

    // public List<Plat> getPlats() {
    //     return plats;
    // }

    // public void setPlats(List<Plat> plats) {
    //     this.plats = plats;
    // }
}
