package com.tdd.recipe.linkedintddapp.test;


import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import com.tdd.recipe.linkedintddapp.injection.TestRecipeApplication;

public class CustomTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, TestRecipeApplication.class.getName(), context);
    }
}
