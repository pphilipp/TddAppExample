package com.tdd.recipe.linkedintddapp.test;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.tdd.recipe.linkedintddapp.R;
import com.tdd.recipe.linkedintddapp.data.local.InMemoryFavorites;
import com.tdd.recipe.linkedintddapp.injection.TestRecipeApplication;
import com.tdd.recipe.linkedintddapp.ui.resipe.RecipeActivity;

import org.junit.Before;

public class RecipeRobot extends ScreenRobot<RecipeRobot> {
    private final InMemoryFavorites favorites;

    public RecipeRobot () {
        TestRecipeApplication app = (TestRecipeApplication) InstrumentationRegistry.getTargetContext().getApplicationContext();
        favorites = (InMemoryFavorites) app.getFavorites();
        favorites.clear();
    }

    public RecipeRobot launch(ActivityTestRule rule){
        rule.launchActivity(null);
        return this;
    }
    public RecipeRobot launch(ActivityTestRule rule, String id){
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.EXTRA_ID, id);
        rule.launchActivity(intent);
        return this;
    }

    public RecipeRobot noTitle() {
        return checkIsHidden(R.id.tv_title);
    }

    public RecipeRobot description(@StringRes int stringId) {
        return chackViewHasText(R.id.tv_description, stringId);
    }

    public RecipeRobot setFavorites(String id) {
        favorites.put(id, true);
        return this;
    }

    public RecipeRobot isFavorites() {
        return checkIsSelected(R.id.tv_title);
    }
}
