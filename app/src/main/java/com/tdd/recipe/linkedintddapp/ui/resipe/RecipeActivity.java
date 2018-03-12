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

public class RecipeActivity extends AppCompatActivity {
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
        final Recipe recipe = store.getRecipe(id);

        // Step 3: If recipe is null, show error
        if (recipe == null) {
            tvTitle.setVisibility(View.GONE);
            tvDescription.setText(R.string.recipe_not_found);
            return;
        }

        // Step 4: if recipe is not null, show recipe
        RecipeApplication application = (RecipeApplication) getApplication();
        final Favorites preferences = application.getFavorites();
        boolean isFavorite = preferences.get(recipe.id);

        tvTitle.setText(recipe.title);
        tvTitle.setSelected(isFavorite);
        tvDescription.setText(recipe.description);

        // Step 5: When title is clicked, toggle the favorites
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = preferences.toggle(recipe.id);
                tvTitle.setSelected(result);
            }
        });
    }
}
