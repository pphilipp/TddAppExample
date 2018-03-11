package com.tdd.recipe.linkedintddapp.data.local;


public interface Favorites {
    boolean get(String id);
    boolean toggle(String id);
}
