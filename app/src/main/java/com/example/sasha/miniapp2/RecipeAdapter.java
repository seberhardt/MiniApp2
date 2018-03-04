package com.example.sasha.miniapp2;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ViewDragHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
public class RecipeAdapter extends BaseAdapter  {
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
    public Object getItem(int position) {
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
            holder.titleTextView = convertView.findViewById(R.id.recipe_list_title);
            holder.servingTextView = convertView.findViewById(R.id.recipe_list_serving);
            holder.timeTextView = convertView.findViewById(R.id.recipe_list_time);
            holder.thumbnailImageView = convertView.findViewById(R.id.recipe_list_thumbnail);

            //add holder to view
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }
        TextView titleTextView = holder.titleTextView;
        TextView servingTextView = holder.servingTextView;
        TextView timeTextView = holder.timeTextView;
        ImageView thumbnailImageView = holder.thumbnailImageView;

        Recipe recipe = (Recipe)getItem(position);

        //update row view to display info
        titleTextView.setText(recipe.title);
        titleTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
        titleTextView.setTextSize(18);

        servingTextView.setText(recipe.servings + " servings");
        servingTextView.setTextSize(14);
        servingTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));

        timeTextView.setText(recipe.prepTime + " servings");
        timeTextView.setTextSize(14);
        timeTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));

        Picasso.with(mContext).load(recipe.imageUrl).into(thumbnailImageView);

        return convertView;
    }

    private static class ViewHolder{
        public TextView titleTextView;
        public TextView servingTextView;
        public TextView timeTextView;
        public ImageView thumbnailImageView;

    }
}
