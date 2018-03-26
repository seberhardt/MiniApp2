package com.example.sasha.miniapp2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sasha on 2/28/2018.
 */

public class SearchActivity extends AppCompatActivity {
    Context mContext;
    Spinner mDietSpinner;
    Spinner mTimeSpinner;
    Spinner mServingsSpinner;
    Activity goToResultActivity;
    Button submitButton;
    //TextView numberView;
    ArrayList<Recipe> unfilteredArrayList;
    ArrayList<Recipe> recipeArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        goToResultActivity = SearchActivity.this;


        final Intent i = getIntent();

        unfilteredArrayList = i.getParcelableArrayListExtra("recipeList");
        ArrayList<String> labelList = i.getStringArrayListExtra("label_list");
        Set<String> hs = new HashSet<>();
        hs.addAll(labelList);
        labelList.clear();              //remove repeat elements from list for spinner
        labelList.addAll(hs);

        mContext = this;
        //numberView = findViewById(R.id.numberview);
        submitButton = findViewById(R.id.submit_button);
        mDietSpinner = findViewById(R.id.diet_spinner);
        mTimeSpinner = findViewById(R.id.time_spinner);
        mServingsSpinner = findViewById(R.id.servings_spinner);

        final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.serving_restriction, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.prep_time, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> dietAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, labelList);
        dietAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //numberView.setText("there are " + recipeArrayList.size() + " recipes");
        mDietSpinner.setAdapter(dietAdapter);
        mTimeSpinner.setAdapter(adapter2);
        mServingsSpinner.setAdapter(adapter1);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String diet = mDietSpinner.getSelectedItem().toString();
                String time = mTimeSpinner.getSelectedItem().toString();
                String serving = mServingsSpinner.getSelectedItem().toString();
                launchActivity();
            }
        });
    }

    private void launchActivity() {
        Intent intent2 = new Intent(mContext, ResultActivity.class);
        intent2.putExtra("diet_search", mDietSpinner.getSelectedItem().toString());
        intent2.putExtra("time_search", mTimeSpinner.getSelectedItem().toString());
        intent2.putExtra("serving_search", mServingsSpinner.getSelectedItem().toString());
        intent2.putExtra("recipeList", recipeArrayList);
        startActivity(intent2);
    }


    }



