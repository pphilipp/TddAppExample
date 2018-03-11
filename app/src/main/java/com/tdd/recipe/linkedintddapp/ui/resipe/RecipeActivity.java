package com.tdd.recipe.linkedintddapp.ui.resipe;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tdd.recipe.linkedintddapp.R;
import com.tdd.recipe.linkedintddapp.data.local.RecipeStore;
import com.tdd.recipe.linkedintddapp.data.local.SharedPreferencesFavorites;
import com.tdd.recipe.linkedintddapp.data.model.Recipe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "id";

    @BindView(R.id.tv_title) TextView tvTitle;
    @BindView(R.id.tv_description) TextView tvDescription;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);

        RecipeStore store = new RecipeStore(this,"recipes");
        String id = getIntent().getStringExtra(EXTRA_ID);
        final Recipe recipe = store.getRecipe(id);


        if (recipe == null) {
            tvTitle.setVisibility(View.GONE);
            tvDescription.setText(R.string.recipe_not_found);
            return;
        }

        final SharedPreferencesFavorites preferences = new SharedPreferencesFavorites(this);
        boolean isFavorite = preferences.get(recipe.id);

        tvTitle.setText(recipe.title);
        tvTitle.setSelected(isFavorite);
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = preferences.toggle(recipe.id);
                tvTitle.setSelected(result);
            }
        });

        tvDescription.setText(recipe.description);
    }
}
