package com.tdd.recipe.linkedintddapp.data.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Recipe {
    public static final String ID_KEY = "id=";
    public static final String TITLE_KEY = "title=";

    public final String id;
    public final String title;
    public final String description;

    private Recipe(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public static Recipe readFromStream(InputStream stream) {
        String id = null;
        String title = null;
        StringBuilder descBuilder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        try {
            for (String line = reader.readLine(); line != null; line = reader.readLine()){
                if (line.startsWith(ID_KEY)){
                    id = line.substring(ID_KEY.length());
                    continue;
                }

                if (line.startsWith(TITLE_KEY)){
                    title = line.substring(TITLE_KEY.length());
                    continue;
                }

                if (descBuilder.length() > 0){
                    descBuilder.append("\n");
                }

                descBuilder.append(line);
            }
        } catch (IOException e) {
            return null;
        }

        return new Recipe(id, title, descBuilder.toString());
    }
}
