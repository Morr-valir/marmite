package com.example.marmite.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.marmite.Model.Ingredient;
import com.example.marmite.Repository.IngredientRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class IngredientController {
    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return ResponseEntity.ok((List<Ingredient>) ingredientRepository.findAll());
    }

    @PostMapping("/ingredients")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        return ResponseEntity.ok(ingredient);
    }

    @GetMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long id) {
        return ResponseEntity.ok(ingredientRepository.findById(id).orElse(null));
    }

    @PutMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        Ingredient ingredientToUpdate = ingredientRepository.findById(id).orElse(null);
        if (ingredientToUpdate != null) {
            ingredientToUpdate.setNom(ingredient.getNom());
        } else {
            return ResponseEntity.notFound().build();
        }
        ingredientRepository.save(ingredientToUpdate);
        return ResponseEntity.ok(ingredientToUpdate);
    }
}
