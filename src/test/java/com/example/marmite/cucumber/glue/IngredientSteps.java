package com.example.marmite.cucumber.glue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.marmite.Model.Ingredient;
import com.example.marmite.Repository.IngredientRepository;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Before;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;

public class IngredientSteps {
    private ObjectMapper objectMapper;

    @Autowired
    private IngredientRepository ingredientRepository;

    private List<Ingredient> expectedIngredients;
    private List<Ingredient> actualIngredients;

    @Before
    public void setup() {
        expectedIngredients = new ArrayList<Ingredient>();
        actualIngredients = new ArrayList<Ingredient>();
        ingredientRepository.deleteAll();
    }

    @Soit("^les ingrédients suivants$")
    public void givenTheFollowingIngredients(List<Ingredient> ingredients) {
        expectedIngredients.addAll(ingredients);
        ingredientRepository.saveAll(ingredients);
    }

    @Quand("^l'utilisateur demande la récupération de tous les ingrédients$")
    public void whenTheUserRequestedAllTheIngredients() {
        objectMapper = new ObjectMapper();
        try {
            String mockedResponse = "[{\"id\": 1352,\"nom\": \"riz\",\"unite\": \"g\",\"quantite\": \"200\"},{\"id\": 1353,\"nom\": \"oeufs\",\"unite\": \"unite\",\"quantite\": \"2\"}]";
            Ingredient[] ingredients = objectMapper.readValue(mockedResponse, Ingredient[].class);
            actualIngredients.addAll(Arrays.asList(ingredients));
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Alors("^l'utilisateur récupère tous les ingrédients$")
    public void thenTheUserWillGetAllTheIngredients() {
        assertEquals(expectedIngredients.size(), actualIngredients.size());
    }
}
