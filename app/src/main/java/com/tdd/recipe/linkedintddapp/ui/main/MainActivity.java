package com.tdd.recipe.linkedintddapp.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tdd.recipe.linkedintddapp.R;
import com.tdd.recipe.linkedintddapp.data.local.RecipeStore;
import com.tdd.recipe.linkedintddapp.data.model.Recipe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.tdd.recipe.linkedintddapp.ui.adapter.RecipeAdapter;

public class MainActivity extends AppCompatActivity {
    public static final String DIR_RECIPES = "recipes";
    @BindView(R.id.rv) RecyclerView recyclerView;
    private List<Recipe> recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initRecyclerView();
    }

    private void initRecyclerView() {
        recipes = new ArrayList<>();
        recipes.addAll(new RecipeStore(this, DIR_RECIPES).recipes);

        RecipeAdapter adapter = new RecipeAdapter(this, recipes);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }
}
