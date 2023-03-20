package com.example.marmite.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.marmite.Model.Recette;
import com.example.marmite.Repository.RecetteRepository;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    @Autowired
    private RecetteRepository recetteRepository;

    @GetMapping("/recette")
    public List<Recette> getAllRecettes() {
        return (List<Recette>) recetteRepository.findAll();
    }
}
