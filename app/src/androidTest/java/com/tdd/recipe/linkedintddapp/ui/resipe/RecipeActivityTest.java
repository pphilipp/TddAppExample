package com.tdd.recipe.linkedintddapp.ui.resipe;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import com.tdd.recipe.linkedintddapp.R;

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
    
    @Rule
    public ActivityTestRule<RecipeActivity> activityTestRule = new ActivityTestRule<>(
            RecipeActivity.class,
            true,
            false);


    @Test
    public void recipeNotFound() throws Exception {
        activityTestRule.launchActivity(null);

        onView(withId(R.id.tv_description)).check(matches(withText(R.string.recipe_not_found)));
        onView(withId(R.id.tv_title)).check(matches(not(isDisplayed())));
    }

    @Test
    public void clickToFavorite() throws Exception {
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.EXTRA_ID,"milk");
        activityTestRule.launchActivity(intent);

        onView(withId(R.id.tv_title))
                .check(matches(withText("Milk")))
                .check(matches(not(isSelected())))
                .perform(click())
                .check(matches(isSelected()));

    }
}