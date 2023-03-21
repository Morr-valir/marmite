package com.example.marmite.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.marmite.Model.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, String> {
}
