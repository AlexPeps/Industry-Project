package com.example.IndustryProject.db.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.IndustryProject.db.AppDB;
import com.example.IndustryProject.db.dao.FoodDao;
import com.example.IndustryProject.db.entities.FoodItems;

import java.util.List;

public class FoodRepository {

    private FoodDao foodDao;

    public FoodRepository(Application application) {
        AppDB db = AppDB.getInstance(application);
        foodDao = db.foodDao();
    }

    public void insert(FoodItems food) {
        new InsertFoodAsyncTask(foodDao).execute(food);
    }

    public void delete(FoodItems food) {
        new DeleteFoodAsyncTask(foodDao).execute(food);
    }
    public LiveData<List<FoodItems>> getAllFoodItems(){
        return foodDao.getAllFoodItems();
    }


    private static class InsertFoodAsyncTask extends AsyncTask<FoodItems, Void, Void> {
        private FoodDao foodDao;

        private InsertFoodAsyncTask(FoodDao foodDao) {
            this.foodDao = foodDao;
        }

        @Override
        protected Void doInBackground(FoodItems... foodItems) {
            foodDao.insert(foodItems[0]);
            return null;
        }
    }

    private static class DeleteFoodAsyncTask extends AsyncTask<FoodItems, Void, Void> {
        private FoodDao foodDao;

        private DeleteFoodAsyncTask(FoodDao foodDao) {
            this.foodDao = foodDao;
        }

        @Override
        protected Void doInBackground(FoodItems... foodItems) {
            foodDao.delete(foodItems[0]);
            return null;
        }
    }
}
