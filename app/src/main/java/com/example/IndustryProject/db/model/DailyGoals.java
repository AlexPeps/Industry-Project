package com.example.IndustryProject.db.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "DailyGoals",
foreignKeys = {
        @ForeignKey(
                entity = BodyDetails.class,
                parentColumns = "Body Details ID",
                childColumns = "Body_Details_ID"
        ),
        @ForeignKey(
                entity = Exercise.class,
                parentColumns = "Exercise ID",
                childColumns = "Exercise_ID"
        ),
        @ForeignKey(
                entity = FoodItems.class,
                parentColumns = "Food Items ID",
                childColumns = "Food_Items_ID"
        ),
        @ForeignKey(
                entity = Goals.class,
                parentColumns = "Goals ID",
                childColumns = "Goals_ID"
        )
        /*
        @ForeignKey(
                entity = PastGoals.class,
                parentColumns = "Past Goals ID",
                childColumns = "Past_Goals_ID"
        )

         */
})

public class DailyGoals implements Serializable {

    //Goal details
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Daily Goals ID")
    public int DGOD;



    @ColumnInfo(name = "Step Goal")
    public String stepGoal;

    @ColumnInfo(name = "Body_Details_ID")
    public String bodysBodyID;

    @ColumnInfo(name = "Food_Items_ID")
    public String foodsFoodID;

    @ColumnInfo(name = "Exercise_ID")
    public String exercisesExeriseID;

    @ColumnInfo(name = "Goals_ID")
    public String goalsGoalID;


    @ColumnInfo(name = "CalorieGoal")
    public String calorieGoal;



}
