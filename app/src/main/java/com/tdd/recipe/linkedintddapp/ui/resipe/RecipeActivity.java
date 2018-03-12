package com.tdd.recipe.linkedintddapp.ui.resipe;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tdd.recipe.linkedintddapp.R;
import com.tdd.recipe.linkedintddapp.data.local.Favorites;
import com.tdd.recipe.linkedintddapp.data.local.RecipeStore;
import com.tdd.recipe.linkedintddapp.data.local.SharedPreferencesFavorites;
import com.tdd.recipe.linkedintddapp.data.model.Recipe;
import com.tdd.recipe.linkedintddapp.injection.RecipeApplication;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeActivity extends AppCompatActivity implements RecipeContract.View {
    public static final String EXTRA_ID = "id";

    @BindView(R.id.tv_title) TextView tvTitle;
    @BindView(R.id.tv_description) TextView tvDescription;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        // Step 1: Setup the UI
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);

        // Step 2: Load recipe from store
        RecipeStore store = new RecipeStore(this,"recipes");
        String id = getIntent().getStringExtra(EXTRA_ID);
        RecipeApplication application = (RecipeApplication) getApplication();
        final Favorites favoritesPrefs = application.getFavorites();
        final RecipePresenter presenter = new RecipePresenter(store, this, favoritesPrefs);
        presenter.loadRecipe(id);

        // Step 3: If recipe is null, show error - DONE in the presenter

        // Step 4: if recipe is not null, show recipe - DONE in the presenter

        // Step 5: When title is clicked, toggle the favorites
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.toggleFavorite();
            }
        });
    }

    @Override
    public void showRecipeNotFoundError() {
        tvTitle.setVisibility(View.GONE);
        tvDescription.setText(R.string.recipe_not_found);
    }

    @Override
    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    @Override
    public void setDescription(String description) {
        tvDescription.setText(description);
    }

    @Override
    public void setFavorites(boolean isFavorites) {
        tvTitle.setSelected(isFavorites);
    }
}
