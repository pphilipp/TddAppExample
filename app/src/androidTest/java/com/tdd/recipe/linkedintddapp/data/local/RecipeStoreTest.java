package com.tdd.recipe.linkedintddapp.data.local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.tdd.recipe.linkedintddapp.data.model.Recipe;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeStoreTest {

    @Test
    public void nullDirectory() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, null);
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(0, store.recipes.size());
    }

    @Test
    public void count() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(2, store.recipes.size());
    }

    @Test
    public void getWaterRecipe() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        Recipe recipe =  store.getRecipe("milk");

        assertNotNull(recipe);
        assertEquals("milk", recipe.id);
        assertEquals("Milk", recipe.title);
    }
}