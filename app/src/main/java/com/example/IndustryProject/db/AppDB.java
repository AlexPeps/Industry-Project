package com.example.IndustryProject.db;

import android.content.Context;

import com.example.IndustryProject.db.dao.DatabaseDao;
import com.example.IndustryProject.db.model.BodyDetails;
import com.example.IndustryProject.db.model.DailyGoals;
import com.example.IndustryProject.db.model.Exercise;
import com.example.IndustryProject.db.model.FoodItems;
import com.example.IndustryProject.db.model.Goals;
import com.example.IndustryProject.db.model.User;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {User.class, Goals.class, FoodItems.class, Exercise.class, DailyGoals.class, BodyDetails.class}, version = 1, exportSchema = false)

public abstract class AppDB extends RoomDatabase {
    private static AppDB appDB = null;

    // This is abstract method, implemented by the Room Framework
    public abstract DatabaseDao getDao();

    public static AppDB createAppDBInstance(Context context){
        if(appDB == null){
            appDB = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDB.class,
                    "AppDB"
            )
                    .build();
        }
        return appDB;
    }

}