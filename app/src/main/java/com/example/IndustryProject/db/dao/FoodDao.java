package com.example.IndustryProject.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.IndustryProject.db.entities.FoodItems;

import java.util.List;

@Dao
public interface FoodDao {

    @Query("select * from FoodItems")
    LiveData<List<FoodItems>> getAllFoodItems();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(FoodItems foodItems);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long delete(FoodItems foodItems);

}
