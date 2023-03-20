package com.example.marmite.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.marmite.Model.Recette;

@Repository
public interface RecetteRepository extends CrudRepository<Recette, Long> {
}
