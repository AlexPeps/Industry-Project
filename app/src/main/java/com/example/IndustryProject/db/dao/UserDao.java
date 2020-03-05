package com.example.IndustryProject.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.IndustryProject.db.entities.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(User user);

    @Query("select * from Users where user_name like :name")
    LiveData<List<User>> getUser(String name);
}
