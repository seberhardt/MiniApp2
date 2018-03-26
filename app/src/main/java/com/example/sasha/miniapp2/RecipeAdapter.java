package com.example.sasha.miniapp2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by sasha on 2/28/2018.
 */

//adapter takes app and a list of data to display
public class RecipeAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Recipe> mRecipeList;
    private LayoutInflater mInflater;

    //constructor
    public RecipeAdapter(Context mContext, ArrayList<Recipe> mRecipeList){
        this.mContext = mContext;
        this.mRecipeList = mRecipeList;
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return mRecipeList.size();
    }

    @Override
    public Recipe getItem(int position) {
        return mRecipeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //check if view exists
        //if yes no need to inflate and findViewByID
        if (convertView == null) {
            //inflate
            convertView = mInflater.inflate(R.layout.list_item_recipe, parent,false);
            //add view to holder
            holder = new ViewHolder();
            //view
            holder.dietTextView = convertView.findViewById(R.id.dietTextView);
            holder.titleTextView = convertView.findViewById(R.id.recipe_list_title);
            holder.servingTextView = convertView.findViewById(R.id.recipe_list_serving);
            holder.timeTextView = convertView.findViewById(R.id.recipe_list_time);
            holder.thumbnailImageView = convertView.findViewById(R.id.recipe_list_thumbnail);
            holder.notifButton = convertView.findViewById(R.id.notif_button);
        //    holder.numberTextView = convertView.findViewById(R.id.numberview);
            //add holder to view
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }
        TextView titleTextView = holder.titleTextView;
        TextView servingTextView = holder.servingTextView;
        TextView timeTextView = holder.timeTextView;
        TextView dietTextView = holder.dietTextView;
        ImageView thumbnailImageView = holder.thumbnailImageView;
        ImageButton notifButton = holder.notifButton;
       // TextView numberTextView = holder.numberTextView;

        final Recipe recipe = (Recipe)getItem(position);

        //update row view to display info
        titleTextView.setText(recipe.title);
        titleTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
        titleTextView.setTextSize(18);

        servingTextView.setText(recipe.servings + " servings");
        servingTextView.setTextSize(14);
        servingTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));

        timeTextView.setText(recipe.prepTime);
        timeTextView.setTextSize(14);
        timeTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));

        dietTextView.setText(recipe.dietLabel);
        dietTextView.setTextSize(14);
        dietTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));

     //   numberTextView.setText("There are " + mRecipeList.size() + " recipes!");

        final Intent openRecipe = new Intent(Intent.ACTION_VIEW);
        openRecipe.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
        openRecipe.setData(Uri.parse(recipe.instructionUrl));
        final PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, openRecipe, 0);

        notifButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                String text = "The instruction for " + recipe.title +" can be found here";
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext, "channel_ID")
                        .setSmallIcon(R.drawable.egg)
                        .setContentTitle("cooking instruction")
                        .setContentText("The instruction for " + recipe.title +" can be found here")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);
                NotificationManagerCompat manager = NotificationManagerCompat.from(mContext);
                manager.notify((int) System.currentTimeMillis(), mBuilder.build());
            }
        });



        Picasso.with(mContext).load(recipe.imageUrl).into(thumbnailImageView);

        return convertView;
    }

    private static class ViewHolder{
        public TextView titleTextView;
        public TextView servingTextView;
        public TextView timeTextView;
        public ImageView thumbnailImageView;
        public TextView dietTextView;
        public ImageButton notifButton;
      //  public TextView numberTextView;

    }



}

