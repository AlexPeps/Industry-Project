package com.example.IndustryProject.db.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.IndustryProject.db.entities.FoodItems;
import com.example.IndustryProject.db.repositories.FoodRepository;

import java.util.List;

public class FoodViewModel extends AndroidViewModel {

    private FoodRepository repository;

    public FoodViewModel(@NonNull Application application) {
        super(application);
        repository = new FoodRepository(application);
    }

    public void insert(FoodItems foodItems) {
        repository.insert(foodItems);
    }

    public void delete(FoodItems foodItems){repository.delete(foodItems);}

    public LiveData<List<FoodItems>> getAllFoodItems() {
        return repository.getAllFoodItems();
    }
}
