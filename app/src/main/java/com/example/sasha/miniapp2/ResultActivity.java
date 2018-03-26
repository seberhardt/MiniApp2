package com.example.sasha.miniapp2;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by sasha on 2/28/2018.
 */

public class ResultActivity extends AppCompatActivity {
    private ListView mListView;
    private Context mContext;
    private ImageButton mImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        Intent i = getIntent();
        String diet_pref = i.getStringExtra("diet_search");
        String time_pref = i.getStringExtra("time_search");
        String serving_pref = i.getStringExtra("serving_search");

        mContext = this;
        final ArrayList<Recipe> recipeList = Recipe.getRecipesFromFile("recipes.json", this);


        ArrayList<Recipe> filteredList = new ArrayList<Recipe>();
        HashSet<Recipe> fromList = new HashSet<Recipe>(recipeList);

        RecipeAdapter adapter = new RecipeAdapter(this, filteredList);

        mImageButton = findViewById(R.id.notif_button);
        mListView = findViewById(R.id.recipe_list_view);
        mListView.setAdapter(adapter);





    }
}
