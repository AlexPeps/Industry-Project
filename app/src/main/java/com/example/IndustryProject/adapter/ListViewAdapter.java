package com.example.IndustryProject.adapter;


import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.example.IndustryProject.R;
import com.example.IndustryProject.db.AppDB;
import com.example.IndustryProject.db.dao.DatabaseDao;
import com.example.IndustryProject.db.entities.FoodItems;
import com.example.IndustryProject.db.repositories.FoodRepository;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter {

    private ArrayList foodList = new ArrayList();
    private Context mContext;

    static class FoodViewHolder {
        TextView ID;
        TextView calories;
        TextView name;
        ImageView image;
        CardView cardView;
        Button button;
    }

    public ListViewAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        mContext = context;
    }

    public void add(String[] object) {
        foodList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.foodList.size();
    }

    @Override
    public Object getItem(int index) {
        return this.foodList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final FoodViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = inflater.inflate(R.layout.layout_user_list, parent, false);
            viewHolder = new FoodViewHolder();
            viewHolder.name = (TextView) row.findViewById(R.id.user_item_card_list_name);
            viewHolder.ID = (TextView) row.findViewById(R.id.user_item_card_list_ID);
            viewHolder.calories = (TextView) row.findViewById(R.id.user_item_card_list_caloriesActual);
            viewHolder.button = (Button) row.findViewById(R.id.button_display);
            row.setTag(viewHolder);
        } else {
            viewHolder = (FoodViewHolder) row.getTag();
        }
        String[] stat = (String[]) getItem(position);
        viewHolder.calories.setText(stat[0]);
        viewHolder.name.setText("Food Item:" + " " + stat[2]);
        viewHolder.ID.setText("Food ID:" + " " + stat[1]);
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FoodItems foodItems = new FoodItems();
                foodItems.setFoodName(viewHolder.name.getText().toString());
                foodItems.setCalories(viewHolder.calories.getText().toString());
                foodItems.setFoodDescription(viewHolder.ID.getText().toString());

                new FoodRepository((Application) mContext).insert(foodItems);
                Toast.makeText(getContext(), viewHolder.name.getText() + " " + "food Item added", Toast.LENGTH_LONG).show();
            }
        });
        return row;
    }

    public void filterList(ArrayList<String[]> filterdNames) {
        this.foodList = filterdNames;
        notifyDataSetChanged();
    }

}
