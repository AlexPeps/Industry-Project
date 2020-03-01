package com.example.IndustryProject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.IndustryProject.db.AppDB;
import com.example.IndustryProject.db.model.FoodItems;

public class InsertFoodItemActivity extends AppCompatActivity {





    public static class InsertFoodItem extends AsyncTask<FoodItems, Void, Void> {

        long insertionResult;




        @Override
        protected Void doInBackground(FoodItems... foodItems) {
         //   insertionResult = MainActivity.userDao.insertFoodItems(foodItems[0]);
            insertionResult = AppDB.instance().getDao().insertFoodItems(foodItems[0]);
            return null;
        }


    }
}