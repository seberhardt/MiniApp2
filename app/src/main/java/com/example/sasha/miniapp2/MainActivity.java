package com.example.sasha.miniapp2;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            CharSequence name = "channel_name";
            String description = "channel_description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("channel_ID", "channel_name", importance);
            channel.setDescription(description);
            // Register the channel with the system
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }


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
        final ArrayList<String> labelList = new ArrayList<>();
        final ArrayList<Recipe> spinnerList = Recipe.getRecipesFromFile("recipes.json", this);
        for (int i = 0; i < spinnerList.size(); i++){
            labelList.add(spinnerList.get(i).dietLabel.toString());
        }
        intent1.putStringArrayListExtra("label_list", labelList);
        intent1.putExtra("recipeList", spinnerList);
        startActivity(intent1);
    }
}
