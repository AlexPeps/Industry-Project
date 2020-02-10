package com.example.IndustryProject;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.example.IndustryProject.db.model.FoodItems;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter {


    //private ArrayList<String[]> foodList;
    private ArrayList foodList = new ArrayList();

    static class FoodViewHolder {
        TextView description;
        TextView calories;
        TextView name;
        ImageView image;
        CardView cardView;
        Button button;
        private ArrayList<String> arraylist;
    }

    //constructor
    public ListViewAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);

    }



   //@Override
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
            viewHolder.description = (TextView) row.findViewById(R.id.user_item_card_list_description);
            viewHolder.calories = (TextView) row.findViewById(R.id.user_item_card_list_calories);
            viewHolder.button =(Button) row.findViewById(R.id.button_display);
            row.setTag(viewHolder);
        } else {
            viewHolder = (FoodViewHolder) row.getTag();
        }
        String[] stat = (String[]) getItem(position);
        viewHolder.name.setText(stat[0]);
        viewHolder.description.setText(stat[1]);
        viewHolder.calories.setText(stat[2]);
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FoodItems foodItems = new FoodItems();
                foodItems.setFoodName(viewHolder.name.toString());
                foodItems.setCalories(viewHolder.calories.toString());
                foodItems.setFoodDescription(viewHolder.description.toString());


                InsertFoodItemActivity.InsertFoodItem insertFoodItem = new InsertFoodItemActivity.InsertFoodItem();
                Toast.makeText(getContext(), viewHolder.name.getText() + " " +"food Item added", Toast.LENGTH_LONG).show();
            }
        });
        return row;

    }
    //This method will filter the list
    //here we are passing the filtered data
    //and assigning it to the list with notifydatasetchanged method
    public void filterList(ArrayList<String> filterdNames) {
        this.foodList = filterdNames;
        notifyDataSetChanged();
    }

}
