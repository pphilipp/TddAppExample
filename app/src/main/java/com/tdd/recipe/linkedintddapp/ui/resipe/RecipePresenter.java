package com.tdd.recipe.linkedintddapp.ui.resipe;


import com.tdd.recipe.linkedintddapp.data.local.Favorites;
import com.tdd.recipe.linkedintddapp.data.local.RecipeStore;
import com.tdd.recipe.linkedintddapp.data.model.Recipe;

public class RecipePresenter implements RecipeContract.Listener{
    private final RecipeStore store;
    private final RecipeContract.View view;
    private final Favorites favoritesPrefs;
    private Recipe recipe;

    public RecipePresenter(RecipeStore store, RecipeContract.View view, Favorites favoritesPrefs) {
        this.store = store;
        this.view = view;
        this.favoritesPrefs = favoritesPrefs;

    }

    public void loadRecipe(String id) {
        recipe = store.getRecipe(id);

        if (recipe == null) {
            view.showRecipeNotFoundError();
        } else {
            view.setTitle(recipe.title);
            view.setDescription(recipe.description);
            view.setFavorites(favoritesPrefs.get(recipe.id));
        }

    }

    public void toggleFavorite() {
        boolean result = favoritesPrefs.toggle(recipe.id);
        view.setFavorites(result);
    }
}
