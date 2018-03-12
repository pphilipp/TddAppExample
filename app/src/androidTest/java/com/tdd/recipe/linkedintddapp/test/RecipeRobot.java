package com.tdd.recipe.linkedintddapp.test;

import com.tdd.recipe.linkedintddapp.R;

public class RecipeRobot extends ScreenRobot<RecipeRobot> {

    public RecipeRobot noTitle() {
        return checkIsHidden(R.id.tv_title);
    }
}
