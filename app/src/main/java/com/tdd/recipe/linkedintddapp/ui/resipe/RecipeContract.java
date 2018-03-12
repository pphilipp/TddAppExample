package com.tdd.recipe.linkedintddapp.ui.resipe;


public interface RecipeContract {
    interface View {
        void showRecipeNotFoundError();
        void setTitle(String title);
        void setDescription(String description);
        void setFavorites(boolean isFavorites);
    }

    interface Listener{

    }
}
