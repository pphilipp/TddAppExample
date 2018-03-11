package com.tdd.recipe.linkedintddapp.ui.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tdd.recipe.linkedintddapp.R;
import com.tdd.recipe.linkedintddapp.data.model.Recipe;
import com.tdd.recipe.linkedintddapp.ui.resipe.RecipeActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<Recipe> recipes;

    public RecipeAdapter(Context context, List<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecipeViewHolder(LayoutInflater
                .from(parent.getContext()).inflate(R.layout.item_recipe, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Recipe recipe = recipes.get(position);
        RecipeViewHolder viewHolder = (RecipeViewHolder) holder;

        viewHolder.recipe = recipe;

        viewHolder.title.setText(recipe.title);
        viewHolder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(context, RecipeActivity.class);
                intent.putExtra(RecipeActivity.EXTRA_ID, recipe.id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder{
        View root;
        Recipe recipe;
        @BindView(R.id.tv_recipe_title) TextView title;


        RecipeViewHolder(View root) {
            super(root);
            ButterKnife.bind(this, root);
            this.root = root;
        }
    }
}
