package com.tdd.recipe.linkedintddapp.data.model;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class RecipeTest {
    @Test
    public void water() {
        InputStream stream = RecipeTest.class.getResourceAsStream("/recipes/water.txt");
        Recipe recipe = Recipe.readFromStream(stream);

        assertNotNull(recipe);
        assertEquals("water", recipe.id);
        assertEquals("Water", recipe.title);
        assertEquals("Put glass under tap. Open tap. Close tap. Drink.", recipe.description);

    }

    @Test
    public void mixed() {
        InputStream stream = RecipeTest.class.getResourceAsStream("/recipes/mixed.txt");
        Recipe recipe = Recipe.readFromStream(stream);

        assertNotNull(recipe);
        assertEquals("punch", recipe.id);
        assertEquals("Punch", recipe.title);
        assertEquals("Juis oj 3 lemon\n" +
                "1 orange\n" +
                "1 pint of something\n" +
                "2 peaces of sheet\n" +
                "Mix and drink a cup of hot sheet.", recipe.description);
    }
}