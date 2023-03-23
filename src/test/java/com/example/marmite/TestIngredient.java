package com.example.marmite;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;
import org.easymock.EasyMock;
import org.easymock.Mock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.marmite.Model.Ingredient;
import com.example.marmite.Repository.IngredientRepository;

@SpringBootTest
public class TestIngredient {

    @InjectMocks
    private IngredientRepository ingredientRepository;
    @Mock
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredientRepository = EasyMock.createMock(IngredientRepository.class);
        System.out.println("Lancement du test");
    }

    @Test
    public void testFindById() throws Exception {
        // Créer un objet Ingredient avec des valeurs arbitraires
        ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setNom("Tomate");
        ingredient.setUnite("kg");
        ingredient.setQuantite("2");

        // Définir le comportement attendu pour la méthode findById()
        EasyMock.expect(ingredientRepository.findById(1L)).andReturn(Optional.of(ingredient));
        EasyMock.replay(ingredientRepository);

        // Appeler la méthode findById() de IngredientRepository
        Ingredient result = ingredientRepository.findById(1L).orElse(null);

        // Vérifier que l'objet retourné n'est pas null et que ses propriétés sont égales à celles définies précédemment
        assertNotNull(result);
        assertEquals("Tomate", result.getNom());
        assertEquals("kg", result.getUnite());
        assertEquals("2", result.getQuantite());

        System.out.println("Test findById OK");
    }

    @Test
    public void testSave() throws Exception {
        // Créer un objet Ingredient avec des valeurs arbitraires
        ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setNom("Tomate");
        ingredient.setUnite("kg");
        ingredient.setQuantite("2");

        // Définir le comportement attendu pour la méthode save()
        EasyMock.expect(ingredientRepository.save(ingredient)).andReturn(ingredient);
        EasyMock.replay(ingredientRepository);

        // Appeler la méthode save() de IngredientRepository
        Ingredient result = ingredientRepository.save(ingredient);

        // Vérifier que l'objet retourné n'est pas null et que ses propriétés sont égales à celles définies précédemment
        assertNotNull(result);
        assertEquals("Tomate", result.getNom());
        assertEquals("kg", result.getUnite());
        assertEquals("2", result.getQuantite());

        System.out.println("Test save OK");
    }
}
