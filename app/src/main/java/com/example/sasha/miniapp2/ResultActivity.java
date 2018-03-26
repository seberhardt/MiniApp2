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

//        ArrayList<Recipe> filteredList = new ArrayList<Recipe>();
//        for (int r = 0; r< recipeList.size(); r++){
//            if (recipeList.get(r).dietLabel == diet_pref){
//               if (time_pref.contains("30 min or less") && !recipeList.get(r).prepTime.contains("hours") && Integer.parseInt(recipeList.get(r).prepTime.substring(0,2)) <= 30){
//                   if (serving_pref.contains("less than 4") && Integer.parseInt(recipeList.get(r).servings) < 4) {
//                       filteredList.add(recipeList.get(r)); }
//                   else if (serving_pref.contains("4-6")&& (Integer.parseInt(recipeList.get(r).servings) <= 6) && (Integer.parseInt(recipeList.get(r).servings) >= 4)) {
//                       filteredList.add(recipeList.get(r)); }
//                   }
//                   else if (serving_pref.contains("7-9") &&(Integer.parseInt(recipeList.get(r).servings)) >=7 && (Integer.parseInt(recipeList.get(r).servings) <=9)){
//                    filteredList.add(recipeList.get(r)); }
//            }
//               else if (time_pref.contains("less than 1 hr") && !recipeList.get(r).prepTime.contains("hours")&& Integer.parseInt(recipeList.get(r).prepTime.substring(0,2)) <= 60){
//                   if (serving_pref.contains("less than 4") && Integer.parseInt(recipeList.get(r).servings) < 4) {
//                            filteredList.add(recipeList.get(r));
//                       }
//                    if (serving_pref.contains("less than 4") && Integer.parseInt(recipeList.get(r).servings) < 4) {
//                    filteredList.add(recipeList.get(r)); }
//                     else if (serving_pref.contains("4-6")&& (Integer.parseInt(recipeList.get(r).servings) <= 6) && (Integer.parseInt(recipeList.get(r).servings) >= 4)) {
//                    filteredList.add(recipeList.get(r)); }
//                    }
//                     else if (serving_pref.contains("7-9") &&(Integer.parseInt(recipeList.get(r).servings)) >=7 && (Integer.parseInt(recipeList.get(r).servings) <=9)){
//                     filteredList.add(recipeList.get(r)); }
//               else if (time_pref.contains("more than 1 hr") && recipeList.get(r).prepTime.contains("hours")){
//                   if (serving_pref.contains("less than 4") && Integer.parseInt(recipeList.get(r).servings) < 4) {
//                           filteredList.add(recipeList.get(r));
//                       }
//                if (serving_pref.contains("less than 4") && Integer.parseInt(recipeList.get(r).servings) < 4) {
//                    filteredList.add(recipeList.get(r)); }
//                else if (serving_pref.contains("4-6")&& (Integer.parseInt(recipeList.get(r).servings) <= 6) && (Integer.parseInt(recipeList.get(r).servings) >= 4)) {
//                    filteredList.add(recipeList.get(r)); }
//                 else if (serving_pref.contains("7-9") &&(Integer.parseInt(recipeList.get(r).servings)) >=7 && (Integer.parseInt(recipeList.get(r).servings) <=9)){
//                filteredList.add(recipeList.get(r)); }
//
//            }
//        }


        RecipeAdapter adapter = new RecipeAdapter(this, recipeList);

        mImageButton = findViewById(R.id.notif_button);
        mListView = findViewById(R.id.recipe_list_view);
        mListView.setAdapter(adapter);





    }
}
