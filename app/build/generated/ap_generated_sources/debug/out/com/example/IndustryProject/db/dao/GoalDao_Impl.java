package com.example.IndustryProject.db.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.IndustryProject.db.entities.Goals;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GoalDao_Impl implements GoalDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfGoals;

  public GoalDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGoals = new EntityInsertionAdapter<Goals>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Goals`(`Goals ID`,`Step Goal`,`Calorie Goal`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Goals value) {
        stmt.bindLong(1, value.GOD);
        if (value.stepGoal == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.stepGoal);
        }
        if (value.calorieGoal == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.calorieGoal);
        }
      }
    };
  }

  @Override
  public long insert(final Goals goals) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfGoals.insertAndReturnId(goals);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }
}
