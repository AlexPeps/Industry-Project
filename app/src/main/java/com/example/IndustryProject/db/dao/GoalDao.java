package com.example.IndustryProject.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.IndustryProject.db.entities.Goals;

@Dao
public interface GoalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Goals goals);
}
