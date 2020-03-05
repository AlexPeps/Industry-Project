package com.example.IndustryProject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.IndustryProject.db.entities.FoodItems;
import com.example.IndustryProject.db.viewModel.FoodViewModel;

import java.util.List;

public class FoodBreakdownActivity extends AppCompatActivity {

    private FoodBreakdownRecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private FoodViewModel foodViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_break);
        foodViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);

        recyclerView = findViewById(R.id.listFoodBreak);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new FoodBreakdownRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
        foodViewModel.getAllFoodItems().observe(this, new Observer<List<FoodItems>>() {
            @Override
            public void onChanged(List<FoodItems> foodItems) {
                adapter.add(foodItems);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
