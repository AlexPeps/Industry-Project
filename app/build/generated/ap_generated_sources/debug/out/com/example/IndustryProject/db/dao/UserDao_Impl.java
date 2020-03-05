package com.example.IndustryProject.db.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.IndustryProject.db.entities.User;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUser;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Users`(`User ID`,`First Name`,`Last Name`,`user_Name`,`Password`,`Address`,`Gender`,`Mobile Number`,`Step Goal`,`CalorieGoal`,`Age`,`BMR`,`Lifestyle`,`Weight`,`Height`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.SID);
        if (value.firstName == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.firstName);
        }
        if (value.lastName == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.lastName);
        }
        if (value.userName == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.userName);
        }
        if (value.password == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.password);
        }
        if (value.address == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.address);
        }
        if (value.gender == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.gender);
        }
        if (value.mobileNumber == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.mobileNumber);
        }
        if (value.stepGoal == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.stepGoal);
        }
        if (value.calorieGoal == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.calorieGoal);
        }
        if (value.age == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.age);
        }
        if (value.bmr == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.bmr);
        }
        if (value.lifestyle == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.lifestyle);
        }
        if (value.weight == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.weight);
        }
        if (value.height == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.height);
        }
      }
    };
  }

  @Override
  public long insert(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfUser.insertAndReturnId(user);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<User>> getUser(final String name) {
    final String _sql = "select * from Users where user_name like ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Users"}, false, new Callable<List<User>>() {
      @Override
      public List<User> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfSID = CursorUtil.getColumnIndexOrThrow(_cursor, "User ID");
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "First Name");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "Last Name");
          final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "user_Name");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "Password");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "Address");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "Gender");
          final int _cursorIndexOfMobileNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "Mobile Number");
          final int _cursorIndexOfStepGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "Step Goal");
          final int _cursorIndexOfCalorieGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "CalorieGoal");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "Age");
          final int _cursorIndexOfBmr = CursorUtil.getColumnIndexOrThrow(_cursor, "BMR");
          final int _cursorIndexOfLifestyle = CursorUtil.getColumnIndexOrThrow(_cursor, "Lifestyle");
          final int _cursorIndexOfWeight = CursorUtil.getColumnIndexOrThrow(_cursor, "Weight");
          final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "Height");
          final List<User> _result = new ArrayList<User>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final User _item;
            _item = new User();
            _item.SID = _cursor.getInt(_cursorIndexOfSID);
            _item.firstName = _cursor.getString(_cursorIndexOfFirstName);
            _item.lastName = _cursor.getString(_cursorIndexOfLastName);
            _item.userName = _cursor.getString(_cursorIndexOfUserName);
            _item.password = _cursor.getString(_cursorIndexOfPassword);
            _item.address = _cursor.getString(_cursorIndexOfAddress);
            _item.gender = _cursor.getString(_cursorIndexOfGender);
            _item.mobileNumber = _cursor.getString(_cursorIndexOfMobileNumber);
            _item.stepGoal = _cursor.getString(_cursorIndexOfStepGoal);
            _item.calorieGoal = _cursor.getString(_cursorIndexOfCalorieGoal);
            _item.age = _cursor.getString(_cursorIndexOfAge);
            _item.bmr = _cursor.getString(_cursorIndexOfBmr);
            _item.lifestyle = _cursor.getString(_cursorIndexOfLifestyle);
            _item.weight = _cursor.getString(_cursorIndexOfWeight);
            _item.height = _cursor.getString(_cursorIndexOfHeight);
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
