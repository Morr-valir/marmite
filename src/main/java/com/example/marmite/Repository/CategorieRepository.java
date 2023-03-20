package com.example.marmite.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.marmite.Model.Categorie;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Long> {
}

