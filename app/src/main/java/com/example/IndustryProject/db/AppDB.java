package com.example.IndustryProject.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.IndustryProject.db.dao.DatabaseDao;
import com.example.IndustryProject.db.dao.FoodDao;
import com.example.IndustryProject.db.dao.GoalDao;
import com.example.IndustryProject.db.dao.UserDao;
import com.example.IndustryProject.db.entities.User;
import com.example.IndustryProject.db.entities.BodyDetails;
import com.example.IndustryProject.db.entities.DailyGoals;
import com.example.IndustryProject.db.entities.Exercise;
import com.example.IndustryProject.db.entities.FoodItems;
import com.example.IndustryProject.db.entities.Goals;


@Database(entities = {User.class, Goals.class, FoodItems.class, Exercise.class, DailyGoals.class, BodyDetails.class}, version = 1, exportSchema = false)

public abstract class AppDB extends RoomDatabase {

    private static AppDB instance;

    public abstract UserDao userDao();
    public abstract GoalDao goalDao();
    public abstract FoodDao foodDao();

    public abstract DatabaseDao getDao();

    public static synchronized AppDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDB.class, "app_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}