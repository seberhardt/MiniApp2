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
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by sasha on 2/28/2018.
 */

public class SearchActivity extends AppCompatActivity{
    Context mContext;
    Spinner mDietSpinner;
    Spinner mTimeSpinner;
    Spinner mServingsSpinner;
    Activity goToResultActivity;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        mContext = this;
        submitButton = findViewById(R.id.submit_button);
        mDietSpinner = findViewById(R.id.diet_spinner);
        mTimeSpinner = findViewById(R.id.time_spinner);
        mServingsSpinner = findViewById(R.id.servings_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDietSpinner.setAdapter(adapter);
        mTimeSpinner.setAdapter(adapter);
        mServingsSpinner.setAdapter(adapter);




        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                launchActivity();
            }
        });



    }
    private void launchActivity() {
        Intent intent2 = new Intent(mContext, ResultActivity.class);
        startActivity(intent2);
    }


    }

