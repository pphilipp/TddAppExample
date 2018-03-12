package com.tdd.recipe.linkedintddapp.test;

import android.support.annotation.StringRes;
import android.support.test.rule.ActivityTestRule;

import com.tdd.recipe.linkedintddapp.R;

public class RecipeRobot extends ScreenRobot<RecipeRobot> {

    public RecipeRobot launch(ActivityTestRule rule){
        rule.launchActivity(null);
        return this;
    }

    public RecipeRobot noTitle() {
        return checkIsHidden(R.id.tv_title);
    }

    public RecipeRobot description(@StringRes int stringId) {
        return chackViewHasText(R.id.tv_description, stringId);
    }
}
