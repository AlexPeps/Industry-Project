package com.example.IndustryProject.db.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Goals")
public class Goals implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Goals ID")
    public int GOD;

    @ColumnInfo(name = "Step Goal")
    public String stepGoal;

    @ColumnInfo(name = "Calorie Goal")
    public String calorieGoal;

    public void setStepGoal (String stepGoal) {
        this.stepGoal = stepGoal;
    }

    public void setCalorieGoal (String calorieGoal) {
        this.calorieGoal = calorieGoal;
    }

    public String getStepGoal() {
        return stepGoal;
    }

    public String getCalorieGoal() {
        return calorieGoal;
    }
}
