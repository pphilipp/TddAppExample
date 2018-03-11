package com.tdd.recipe.linkedintddapp.data.local;


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesFavorites implements Favorites{
    private final SharedPreferences preferences;

    public SharedPreferencesFavorites(Context context) {
        preferences = context.getSharedPreferences("favorites.xml", Context.MODE_PRIVATE);
    }

    @Override
    public boolean get(String id) {
        return preferences.getBoolean(id, false);
    }

    public void put(String id, boolean isFavorite){
        SharedPreferences.Editor editor = preferences.edit();
        if (isFavorite)
            editor.putBoolean(id, true);
        else
            editor.remove(id);
        editor.apply();
    }

    @Override
    public boolean toggle(String id) {
        boolean favorite = get(id);
        put(id, !favorite);
        return !favorite;
    }

}
