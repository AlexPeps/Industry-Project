package com.example.IndustryProject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.IndustryProject.db.entities.FoodItems;

import java.util.ArrayList;
import java.util.List;

public class FoodBreakdownRecyclerViewAdapter extends RecyclerView.Adapter<FoodBreakdownViewHolder> {
    List<FoodItems> foodItems = new ArrayList<>();

    public FoodBreakdownRecyclerViewAdapter(){}

    public void add(List<FoodItems> list){
        foodItems = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FoodBreakdownViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_user_list, parent, false);
        return new FoodBreakdownViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodBreakdownViewHolder holder, int position) {
        holder.foodItems = foodItems.get(position);
        holder.Name.setText(holder.foodItems.getFoodName());
        holder.Calories.setText(holder.foodItems.getCalories());
        holder.ID.setText(holder.foodItems.getFoodDescription());

    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

}
