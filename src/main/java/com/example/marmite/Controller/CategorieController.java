package com.example.marmite.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.marmite.Model.Categorie;
import com.example.marmite.Repository.CategorieRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class CategorieController {
    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping("/categories")
    public ResponseEntity<List<Categorie>> getAllCategories() {
        return ResponseEntity.ok((List<Categorie>) categorieRepository.findAll());
    }

    @PostMapping("/categories")
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) {
        categorieRepository.save(categorie);
        return ResponseEntity.ok(categorie);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable Long id) {
        return ResponseEntity.ok(categorieRepository.findById(id).orElse(null));
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable Long id, @RequestBody Categorie categorie) {
        Categorie categorieToUpdate = categorieRepository.findById(id).orElse(null);
        if (categorieToUpdate != null) {
            categorieToUpdate.setNom(categorie.getNom());
        } else {
            return ResponseEntity.notFound().build();
        }
        categorieRepository.save(categorieToUpdate);
        return ResponseEntity.ok(categorieToUpdate);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Categorie> deleteCategorie(@PathVariable Long id) {
        Categorie categorieToDelete = categorieRepository.findById(id).orElse(null);
        if (categorieToDelete != null) {
            categorieRepository.delete(categorieToDelete);
            return ResponseEntity.ok(categorieToDelete);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
