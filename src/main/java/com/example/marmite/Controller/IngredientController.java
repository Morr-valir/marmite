package com.example.marmite.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.marmite.Model.Ingredient;
import com.example.marmite.Repository.IngredientRepository;

@Controller
public class IngredientController {
    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("/api/ingredients")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return ResponseEntity.ok((List<Ingredient>) ingredientRepository.findAll());
    }
}
