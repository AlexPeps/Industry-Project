package com.example.IndustryProject.db.repositories;

import android.app.Application;
import android.os.AsyncTask;

import com.example.IndustryProject.db.AppDB;
import com.example.IndustryProject.db.dao.GoalDao;
import com.example.IndustryProject.db.entities.Goals;

public class GoalRepository {

    private GoalDao goalDao;

    public GoalRepository(Application application) {
        AppDB db = AppDB.getInstance(application);
        goalDao = db.goalDao();
    }

    public void insert(Goals goals) {
        new InsertGoalsAsyncTask(goalDao).execute(goals);
    }

    private static class InsertGoalsAsyncTask extends AsyncTask<Goals, Void, Void> {
        private GoalDao goalDao;

        private InsertGoalsAsyncTask(GoalDao goalDao) {
            this.goalDao = goalDao;
        }

        @Override
        protected Void doInBackground(Goals... goals) {
            goalDao.insert(goals[0]);
            return null;
        }
    }
}
