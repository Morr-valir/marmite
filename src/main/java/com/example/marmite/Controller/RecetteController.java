package com.example.marmite.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.marmite.Model.Recette;
import com.example.marmite.Repository.RecetteRepository;

@RestController
@RequestMapping("/api")
public class RecetteController {
    
    @Autowired
    private RecetteRepository recetteRepository;

    @GetMapping("/recette")
    public List<Recette> getAllRecettes() {
        return (List<Recette>) recetteRepository.findAll();
    }

    @PostMapping("/recette")
    public ResponseEntity<Recette> ajouterRecette(@RequestBody Recette recette) {
        Recette nouvelleRecette = recetteRepository.save(recette);
        return ResponseEntity.created(URI.create("/api/recette/" + nouvelleRecette.getId()))
            .body(nouvelleRecette);
    }

    /**
     * @param id
     * @param recetteDetails
     * @return
     */
    @PutMapping("/recette/{id}")
    public ResponseEntity<Recette> modifierRecette(@PathVariable(value = "id") Long id, @RequestBody Recette recetteDetails){
        // appel du repository
        Recette recette = recetteRepository.findById(id).orElseThrow();

        recette.setId(recetteDetails.getId());
        recette.setNom(recetteDetails.getNom());
        recette.setCategories(recetteDetails.getCategories());
        recette.setListIngredients(recetteDetails.getListIngredients());

        //persistance en BDD
        Recette  updateRecette = recetteRepository.save(recette);
        return ResponseEntity.ok(updateRecette);
    }

    /**
     * @param id
     * @return
     */
    @DeleteMapping("/recette/{id}")
    public ResponseEntity<?> supprimerJoueur(@PathVariable(value = "id") Long id) {
        Recette recette = recetteRepository.findById(id).orElseThrow();
        recetteRepository.delete(recette);
        return ResponseEntity.ok().build();
    }
}
