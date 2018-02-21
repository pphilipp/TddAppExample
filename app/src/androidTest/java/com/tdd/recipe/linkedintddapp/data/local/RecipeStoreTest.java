package com.tdd.recipe.linkedintddapp.data.local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

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
}