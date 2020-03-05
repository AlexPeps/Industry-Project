package com.example.IndustryProject.db.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.IndustryProject.db.entities.User;
import com.example.IndustryProject.db.repositories.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository repository;
    private List<User> users;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
    }

    public void insert(User user){
        repository.insert(user);
    }
    public LiveData<List<User>> getUser(String name){
        return repository.getUser(name);
    }
}
