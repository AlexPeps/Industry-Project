package com.example.IndustryProject.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.IndustryProject.db.entities.BodyDetails;
import com.example.IndustryProject.db.entities.FoodItems;
import com.example.IndustryProject.db.entities.Goals;
import com.example.IndustryProject.db.entities.User;

import java.util.List;


@Dao
public interface DatabaseDao {

    @Query("select * from Users")
    List<User> readAllUsers();

    @Query("select * from Users where user_name = :uName")
    List<User> searchUserByUserName(String uName);

    @Query("select * from FoodItems")
    List<FoodItems> getAllFoodItems();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertUsers(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertGoals(Goals goals);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertFoodItems(FoodItems foodItems);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertBodyDetails(BodyDetails bodyDetails);


    @Update
    int updateUsers(User user);


    @Update
    int updateFoodItems(FoodItems foodItems);

    @Update
    int UpdateBody(BodyDetails bodyDetail);


    @Delete
    int deleteUsers(User user);

    @Delete
    int deleteFoodItems(FoodItems foodItems);

    @Update
    int updateGoals(Goals goal);



}