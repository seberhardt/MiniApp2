package com.example.sasha.miniapp2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton eggButton;
    Activity goToSearchActivity;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();
        goToSearchActivity = MainActivity.this;


        eggButton = (ImageButton) findViewById(R.id.egg_button); //change egg to broken w/ delay on click
        eggButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                eggButton.setImageResource(R.drawable.broken_egg);
                eggButton.setScaleType(ImageButton.ScaleType.CENTER_INSIDE);
                eggButton.setPadding(0, 0, 160, 0);
                launchActivity();
            }
        });



    }
    private void launchActivity() {
        Intent intent1 = new Intent(mContext, SearchActivity.class);
        startActivity(intent1);
    }
}
