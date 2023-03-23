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

    public Categorie() {
    }

    /**
     * @param id
     */
    public Categorie(Long id) {
        this.id = id;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getCategorieParent() {
        return categorieParent;
    }

    /**
     * @param categorieParent
     */
    public void setCategorieParent(Categorie categorieParent) {
        this.categorieParent = categorieParent;
    }

    @Override
    public String toString() {
        return "Categorie [id=" + id + ", nom=" + nom + ", categorieParent=" + categorieParent + "]";
    }

}
