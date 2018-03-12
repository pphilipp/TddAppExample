package com.tdd.recipe.linkedintddapp.ui.resipe;

import android.support.test.rule.ActivityTestRule;
import com.tdd.recipe.linkedintddapp.R;
import com.tdd.recipe.linkedintddapp.test.RecipeRobot;
import org.junit.Rule;
import org.junit.Test;

public class RecipeActivityTest {
    private final String TEST_ID_MILK = "milk";
    
    @Rule
    public ActivityTestRule<RecipeActivity> activityTestRule = new ActivityTestRule<>(
            RecipeActivity.class,
            true,
            false);

    @Test
    public void recipeNotFound() throws Exception {
        new RecipeRobot()
                .launch(activityTestRule)
                .noTitle()
                .description(R.string.recipe_not_found);
    }

    @Test
    public void clickToFavorite() throws Exception {
        new RecipeRobot()
                .launch(activityTestRule, TEST_ID_MILK)
                .isNotFavorites();
    }

    @Test
    public void clickToAlreadyFavorite() throws Exception {
        new RecipeRobot()
                .setFavorites(TEST_ID_MILK)
                .launch(activityTestRule, TEST_ID_MILK)
                .isFavorites();
    }
}