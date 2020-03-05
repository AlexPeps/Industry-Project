package com.example.IndustryProject.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Exercise")
public class Exercise {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Exercise ID")
    public int EID;

    @ColumnInfo(name = "Exercise Description")
    public String exerciseDescription;

    @ColumnInfo(name = "Calorie Amount")
    public String calorieAmount;
}
