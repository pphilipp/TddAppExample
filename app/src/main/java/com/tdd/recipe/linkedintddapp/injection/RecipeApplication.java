package com.tdd.recipe.linkedintddapp.injection;


import android.app.Application;

import com.tdd.recipe.linkedintddapp.data.local.Favorites;
import com.tdd.recipe.linkedintddapp.data.local.SharedPreferencesFavorites;

public class RecipeApplication extends Application {
    Favorites favorites = null;

    public Favorites getFavorites() {
        if (favorites == null)
            favorites = new SharedPreferencesFavorites(this);
        return favorites;
    }
}
