package com.example.IndustryProject.db.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "FoodItems")
public class FoodItems implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Food Items ID")
    public int FOD;

    @ColumnInfo(name = "Food Name")
    public String foodName;

    @ColumnInfo(name = "Food Description")
    public String foodDescription;

    @ColumnInfo(name = "Calories")
    public String calories;

    @ColumnInfo(name = "Total Calories")
    public Float totalCalories;

    public void setFoodName(String foodName){this.foodName = foodName;}

    public void setFoodDescription(String foodDescription) {this.foodDescription = foodDescription;}

    public void setCalories(String calories) {this.calories = calories;}

    public void setTotalCalories(Float totalCalories) {this.totalCalories = totalCalories;}

    public String getFoodName() {return foodName;}

    public String getFoodDescription() {return foodDescription;}

    public String getCalories() {return  calories;}

    public Float getTotalCalories() {return  totalCalories;}
}
