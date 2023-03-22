package com.example.marmite.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.marmite.Model.Recette;

public interface RecetteRepository extends CrudRepository<Recette, Long> {
}
