package com.example.IndustryProject.db.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.IndustryProject.db.AppDB;
import com.example.IndustryProject.db.dao.UserDao;
import com.example.IndustryProject.db.entities.User;

import java.util.List;

public class UserRepository {

    private UserDao userDao;

    public UserRepository(Application application){
        AppDB db = AppDB.getInstance(application);
        userDao = db.userDao();
    }

    public void insert(User user){
        new InsertUserAsyncTask(userDao).execute(user);
    }

    public LiveData<List<User>> getUser(String name){
        return userDao.getUser(name);
    }

    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void>{
        private UserDao userDao;
        private InsertUserAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }
}
