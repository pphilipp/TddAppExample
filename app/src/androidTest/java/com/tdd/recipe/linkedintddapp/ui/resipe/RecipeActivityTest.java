package com.tdd.recipe.linkedintddapp.ui.resipe;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.tdd.recipe.linkedintddapp.R;
import com.tdd.recipe.linkedintddapp.data.local.InMemoryFavorites;
import com.tdd.recipe.linkedintddapp.injection.TestRecipeApplication;
import com.tdd.recipe.linkedintddapp.test.RecipeRobot;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;


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