package com.example.IndustryProject.db.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.IndustryProject.db.entities.FoodItems;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FoodDao_Impl implements FoodDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfFoodItems;

  public FoodDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFoodItems = new EntityInsertionAdapter<FoodItems>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `FoodItems`(`Food Items ID`,`Food Name`,`Food Description`,`Calories`,`Total Calories`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FoodItems value) {
        stmt.bindLong(1, value.FOD);
        if (value.foodName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.foodName);
        }
        if (value.foodDescription == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.foodDescription);
        }
        if (value.calories == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.calories);
        }
        if (value.totalCalories == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.totalCalories);
        }
      }
    };
  }

  @Override
  public long insert(final FoodItems foodItems) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfFoodItems.insertAndReturnId(foodItems);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long delete(final FoodItems foodItems) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfFoodItems.insertAndReturnId(foodItems);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<FoodItems>> getAllFoodItems() {
    final String _sql = "select * from FoodItems";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"FoodItems"}, false, new Callable<List<FoodItems>>() {
      @Override
      public List<FoodItems> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfFOD = CursorUtil.getColumnIndexOrThrow(_cursor, "Food Items ID");
          final int _cursorIndexOfFoodName = CursorUtil.getColumnIndexOrThrow(_cursor, "Food Name");
          final int _cursorIndexOfFoodDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "Food Description");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "Calories");
          final int _cursorIndexOfTotalCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "Total Calories");
          final List<FoodItems> _result = new ArrayList<FoodItems>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FoodItems _item;
            _item = new FoodItems();
            _item.FOD = _cursor.getInt(_cursorIndexOfFOD);
            _item.foodName = _cursor.getString(_cursorIndexOfFoodName);
            _item.foodDescription = _cursor.getString(_cursorIndexOfFoodDescription);
            _item.calories = _cursor.getString(_cursorIndexOfCalories);
            if (_cursor.isNull(_cursorIndexOfTotalCalories)) {
              _item.totalCalories = null;
            } else {
              _item.totalCalories = _cursor.getFloat(_cursorIndexOfTotalCalories);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
