package com.example.IndustryProject;

import java.util.ArrayList;

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

public class FoodBreakdownListAdapter extends ArrayAdapter {

    private ArrayList foodList = new ArrayList();
    FoodItems foodItems;

    static class FoodbreakDownListAdapter {
        TextView ID;
        TextView calories;
        TextView name;
        ImageView image;
        CardView cardView;
        Button button;
        private ArrayList<String> arraylist;

    }


    public FoodBreakdownListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);

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
        final ListViewAdapter.FoodViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = inflater.inflate(R.layout.layout_user_list, parent, false);
            viewHolder = new ListViewAdapter.FoodViewHolder();
            viewHolder.name = (TextView) row.findViewById(R.id.user_item_card_list_name);
            viewHolder.ID = (TextView) row.findViewById(R.id.user_item_card_list_ID);
            viewHolder.calories = (TextView) row.findViewById(R.id.user_item_card_list_caloriesActual);

            row.setTag(viewHolder);
        } else {
            viewHolder = (ListViewAdapter.FoodViewHolder) row.getTag();
        }
        String[] stat = (String[]) getItem(position);
        viewHolder.calories.setText(foodItems.getCalories());
        viewHolder.name.setText(foodItems.getFoodName());
        viewHolder.ID.setText(foodItems.getFoodDescription());

        return row;

    }
    //This method will filter the list
    //here we are passing the filtered data
    //and assigning it to the list with notifydatasetchanged method
    public void filterList(ArrayList<String[]> filterdNames) {
        this.foodList = filterdNames;
        notifyDataSetChanged();
    }

}
