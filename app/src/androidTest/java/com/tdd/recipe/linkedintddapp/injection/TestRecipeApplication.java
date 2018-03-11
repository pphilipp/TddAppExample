package com.tdd.recipe.linkedintddapp.injection;


import com.tdd.recipe.linkedintddapp.data.local.Favorites;
import com.tdd.recipe.linkedintddapp.data.local.InMemoryFavorites;

public class TestRecipeApplication extends RecipeApplication {

    Favorites favorites = new InMemoryFavorites();

    @Override
    public Favorites getFavorites() {
        return favorites;
    }
}
