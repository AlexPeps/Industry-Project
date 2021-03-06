package com.example.IndustryProject.db.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.IndustryProject.db.entities.BodyDetails;
import com.example.IndustryProject.db.entities.FoodItems;
import com.example.IndustryProject.db.entities.Goals;
import com.example.IndustryProject.db.entities.User;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DatabaseDao_Impl implements DatabaseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUser;

  private final EntityInsertionAdapter __insertionAdapterOfGoals;

  private final EntityInsertionAdapter __insertionAdapterOfFoodItems;

  private final EntityInsertionAdapter __insertionAdapterOfBodyDetails;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfFoodItems;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfFoodItems;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfBodyDetails;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfGoals;

  public DatabaseDao_Impl(RoomDatabase __db) {
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
    this.__insertionAdapterOfBodyDetails = new EntityInsertionAdapter<BodyDetails>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `BodyDetails`(`Body Details ID`,`Age`,`BMR`,`Lifestyle`,`Weight`,`Height`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BodyDetails value) {
        stmt.bindLong(1, value.BID);
        if (value.age == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.age);
        }
        if (value.bmr == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.bmr);
        }
        if (value.lifestyle == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.lifestyle);
        }
        if (value.weight == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.weight);
        }
        if (value.height == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.height);
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Users` WHERE `User ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.SID);
      }
    };
    this.__deletionAdapterOfFoodItems = new EntityDeletionOrUpdateAdapter<FoodItems>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `FoodItems` WHERE `Food Items ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FoodItems value) {
        stmt.bindLong(1, value.FOD);
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Users` SET `User ID` = ?,`First Name` = ?,`Last Name` = ?,`user_Name` = ?,`Password` = ?,`Address` = ?,`Gender` = ?,`Mobile Number` = ?,`Step Goal` = ?,`CalorieGoal` = ?,`Age` = ?,`BMR` = ?,`Lifestyle` = ?,`Weight` = ?,`Height` = ? WHERE `User ID` = ?";
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
        stmt.bindLong(16, value.SID);
      }
    };
    this.__updateAdapterOfFoodItems = new EntityDeletionOrUpdateAdapter<FoodItems>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `FoodItems` SET `Food Items ID` = ?,`Food Name` = ?,`Food Description` = ?,`Calories` = ?,`Total Calories` = ? WHERE `Food Items ID` = ?";
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
        stmt.bindLong(6, value.FOD);
      }
    };
    this.__updateAdapterOfBodyDetails = new EntityDeletionOrUpdateAdapter<BodyDetails>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `BodyDetails` SET `Body Details ID` = ?,`Age` = ?,`BMR` = ?,`Lifestyle` = ?,`Weight` = ?,`Height` = ? WHERE `Body Details ID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BodyDetails value) {
        stmt.bindLong(1, value.BID);
        if (value.age == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.age);
        }
        if (value.bmr == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.bmr);
        }
        if (value.lifestyle == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.lifestyle);
        }
        if (value.weight == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.weight);
        }
        if (value.height == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.height);
        }
        stmt.bindLong(7, value.BID);
      }
    };
    this.__updateAdapterOfGoals = new EntityDeletionOrUpdateAdapter<Goals>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Goals` SET `Goals ID` = ?,`Step Goal` = ?,`Calorie Goal` = ? WHERE `Goals ID` = ?";
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
        stmt.bindLong(4, value.GOD);
      }
    };
  }

  @Override
  public long insertUsers(final User user) {
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
  public long insertGoals(final Goals goals) {
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

  @Override
  public long insertFoodItems(final FoodItems foodItems) {
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
  public long insertBodyDetails(final BodyDetails bodyDetails) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfBodyDetails.insertAndReturnId(bodyDetails);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteUsers(final User user) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteFoodItems(final FoodItems foodItems) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfFoodItems.handle(foodItems);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateUsers(final User user) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateFoodItems(final FoodItems foodItems) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfFoodItems.handle(foodItems);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int UpdateBody(final BodyDetails bodyDetail) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfBodyDetails.handle(bodyDetail);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateGoals(final Goals goal) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfGoals.handle(goal);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<User> readAllUsers() {
    final String _sql = "select * from Users";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
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
      _statement.release();
    }
  }

  @Override
  public List<User> searchUserByUserName(final String uName) {
    final String _sql = "select * from Users where user_name = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (uName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, uName);
    }
    __db.assertNotSuspendingTransaction();
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
      _statement.release();
    }
  }

  @Override
  public List<FoodItems> getAllFoodItems() {
    final String _sql = "select * from FoodItems";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
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
      _statement.release();
    }
  }
}
