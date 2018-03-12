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
    private InMemoryFavorites favorites;
    private final String TEST_ID_MILK = "milk";
    
    @Rule
    public ActivityTestRule<RecipeActivity> activityTestRule = new ActivityTestRule<>(
            RecipeActivity.class,
            true,
            false);

    @Before
    public void clearFavorites() {
        TestRecipeApplication app = (TestRecipeApplication) InstrumentationRegistry.getTargetContext().getApplicationContext();
        favorites = (InMemoryFavorites) app.getFavorites();
        favorites.clear();
    }

    @Test
    public void recipeNotFound() throws Exception {
        new RecipeRobot()
                .launch(activityTestRule)
                .noTitle()
                .description(R.string.recipe_not_found);
    }

    @Test
    public void clickToFavorite() throws Exception {
        launchRecipe(TEST_ID_MILK);

        onView(withId(R.id.tv_title))
                .check(matches(withText("Milk")))
                .check(matches(not(isSelected())))
                .perform(click())
                .check(matches(isSelected()));

    }

    @Test
    public void clickToAlreadyFavorite() throws Exception {
        favorites.put(TEST_ID_MILK, true);
        launchRecipe(TEST_ID_MILK);

        onView(withId(R.id.tv_title))
                .check(matches(withText("Milk")))
                .check(matches(isSelected()))
                .perform(click())
                .check(matches(not(isSelected())));
    }

    private void launchRecipe(String id) {
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.EXTRA_ID, id);
        activityTestRule.launchActivity(intent);
    }
}