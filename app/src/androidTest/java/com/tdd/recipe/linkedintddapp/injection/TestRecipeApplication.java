package com.tdd.recipe.linkedintddapp.injection;


import com.tdd.recipe.linkedintddapp.data.local.Favorites;
import com.tdd.recipe.linkedintddapp.data.local.InMemoryFavorites;

public class TestRecipeApplication extends RecipeApplication {
    Favorites favorites = new InMemoryFavorites();

    /**
     * @getFavorites() - provided a @InMemoryFavorites() store.
     * Replacing sharedPreferences data store with InMemory data store for correct testing.
     */
    @Override
    public Favorites getFavorites() {
        return favorites;
    }
}
