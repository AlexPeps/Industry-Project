package com.example.IndustryProject.db.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.IndustryProject.db.entities.Goals;
import com.example.IndustryProject.db.repositories.GoalRepository;

public class GoalViewModel extends AndroidViewModel {

    private GoalRepository repository;

    public GoalViewModel(@NonNull Application application) {
        super(application);
        repository = new GoalRepository(application);
    }

    public void insert(Goals goals) {
        repository.insert(goals);
    }
}
