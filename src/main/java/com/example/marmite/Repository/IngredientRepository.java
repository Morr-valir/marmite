package com.example.marmite.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.marmite.Model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
