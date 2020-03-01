package com.example.IndustryProject.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.IndustryProject.db.dao.DatabaseDao;
import com.example.IndustryProject.db.dao.DatabaseDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDB_Impl extends AppDB {
  private volatile DatabaseDao _databaseDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Users` (`User ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `First Name` TEXT, `Last Name` TEXT, `user_Name` TEXT, `Password` TEXT, `Address` TEXT, `Gender` TEXT, `Mobile Number` TEXT, `Step Goal` TEXT, `CalorieGoal` TEXT, `Age` TEXT, `BMR` TEXT, `Lifestyle` TEXT, `Weight` TEXT, `Height` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Goals` (`Goals ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Step Goal` TEXT, `Calorie Goal` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `FoodItems` (`Food Items ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Food Name` TEXT, `Food Description` TEXT, `Calories` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Exercise` (`Exercise ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Exercise Description` TEXT, `Calorie Amount` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `DailyGoals` (`Daily Goals ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Step Goal` TEXT, `Body_Details_ID` TEXT, `Food_Items_ID` TEXT, `Exercise_ID` TEXT, `Goals_ID` TEXT, `CalorieGoal` TEXT, FOREIGN KEY(`Body_Details_ID`) REFERENCES `BodyDetails`(`Body Details ID`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`Exercise_ID`) REFERENCES `Exercise`(`Exercise ID`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`Food_Items_ID`) REFERENCES `FoodItems`(`Food Items ID`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`Goals_ID`) REFERENCES `Goals`(`Goals ID`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `BodyDetails` (`Body Details ID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Age` TEXT, `BMR` TEXT, `Lifestyle` TEXT, `Weight` TEXT, `Height` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f2e70194da42251ecf358bc9853d4224')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Users`");
        _db.execSQL("DROP TABLE IF EXISTS `Goals`");
        _db.execSQL("DROP TABLE IF EXISTS `FoodItems`");
        _db.execSQL("DROP TABLE IF EXISTS `Exercise`");
        _db.execSQL("DROP TABLE IF EXISTS `DailyGoals`");
        _db.execSQL("DROP TABLE IF EXISTS `BodyDetails`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(15);
        _columnsUsers.put("User ID", new TableInfo.Column("User ID", "INTEGER", true, 1));
        _columnsUsers.put("First Name", new TableInfo.Column("First Name", "TEXT", false, 0));
        _columnsUsers.put("Last Name", new TableInfo.Column("Last Name", "TEXT", false, 0));
        _columnsUsers.put("user_Name", new TableInfo.Column("user_Name", "TEXT", false, 0));
        _columnsUsers.put("Password", new TableInfo.Column("Password", "TEXT", false, 0));
        _columnsUsers.put("Address", new TableInfo.Column("Address", "TEXT", false, 0));
        _columnsUsers.put("Gender", new TableInfo.Column("Gender", "TEXT", false, 0));
        _columnsUsers.put("Mobile Number", new TableInfo.Column("Mobile Number", "TEXT", false, 0));
        _columnsUsers.put("Step Goal", new TableInfo.Column("Step Goal", "TEXT", false, 0));
        _columnsUsers.put("CalorieGoal", new TableInfo.Column("CalorieGoal", "TEXT", false, 0));
        _columnsUsers.put("Age", new TableInfo.Column("Age", "TEXT", false, 0));
        _columnsUsers.put("BMR", new TableInfo.Column("BMR", "TEXT", false, 0));
        _columnsUsers.put("Lifestyle", new TableInfo.Column("Lifestyle", "TEXT", false, 0));
        _columnsUsers.put("Weight", new TableInfo.Column("Weight", "TEXT", false, 0));
        _columnsUsers.put("Height", new TableInfo.Column("Height", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("Users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(_db, "Users");
        if (! _infoUsers.equals(_existingUsers)) {
          throw new IllegalStateException("Migration didn't properly handle Users(com.example.IndustryProject.db.model.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsGoals = new HashMap<String, TableInfo.Column>(3);
        _columnsGoals.put("Goals ID", new TableInfo.Column("Goals ID", "INTEGER", true, 1));
        _columnsGoals.put("Step Goal", new TableInfo.Column("Step Goal", "TEXT", false, 0));
        _columnsGoals.put("Calorie Goal", new TableInfo.Column("Calorie Goal", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGoals = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGoals = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGoals = new TableInfo("Goals", _columnsGoals, _foreignKeysGoals, _indicesGoals);
        final TableInfo _existingGoals = TableInfo.read(_db, "Goals");
        if (! _infoGoals.equals(_existingGoals)) {
          throw new IllegalStateException("Migration didn't properly handle Goals(com.example.IndustryProject.db.model.Goals).\n"
                  + " Expected:\n" + _infoGoals + "\n"
                  + " Found:\n" + _existingGoals);
        }
        final HashMap<String, TableInfo.Column> _columnsFoodItems = new HashMap<String, TableInfo.Column>(4);
        _columnsFoodItems.put("Food Items ID", new TableInfo.Column("Food Items ID", "INTEGER", true, 1));
        _columnsFoodItems.put("Food Name", new TableInfo.Column("Food Name", "TEXT", false, 0));
        _columnsFoodItems.put("Food Description", new TableInfo.Column("Food Description", "TEXT", false, 0));
        _columnsFoodItems.put("Calories", new TableInfo.Column("Calories", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFoodItems = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFoodItems = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFoodItems = new TableInfo("FoodItems", _columnsFoodItems, _foreignKeysFoodItems, _indicesFoodItems);
        final TableInfo _existingFoodItems = TableInfo.read(_db, "FoodItems");
        if (! _infoFoodItems.equals(_existingFoodItems)) {
          throw new IllegalStateException("Migration didn't properly handle FoodItems(com.example.IndustryProject.db.model.FoodItems).\n"
                  + " Expected:\n" + _infoFoodItems + "\n"
                  + " Found:\n" + _existingFoodItems);
        }
        final HashMap<String, TableInfo.Column> _columnsExercise = new HashMap<String, TableInfo.Column>(3);
        _columnsExercise.put("Exercise ID", new TableInfo.Column("Exercise ID", "INTEGER", true, 1));
        _columnsExercise.put("Exercise Description", new TableInfo.Column("Exercise Description", "TEXT", false, 0));
        _columnsExercise.put("Calorie Amount", new TableInfo.Column("Calorie Amount", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExercise = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExercise = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExercise = new TableInfo("Exercise", _columnsExercise, _foreignKeysExercise, _indicesExercise);
        final TableInfo _existingExercise = TableInfo.read(_db, "Exercise");
        if (! _infoExercise.equals(_existingExercise)) {
          throw new IllegalStateException("Migration didn't properly handle Exercise(com.example.IndustryProject.db.model.Exercise).\n"
                  + " Expected:\n" + _infoExercise + "\n"
                  + " Found:\n" + _existingExercise);
        }
        final HashMap<String, TableInfo.Column> _columnsDailyGoals = new HashMap<String, TableInfo.Column>(7);
        _columnsDailyGoals.put("Daily Goals ID", new TableInfo.Column("Daily Goals ID", "INTEGER", true, 1));
        _columnsDailyGoals.put("Step Goal", new TableInfo.Column("Step Goal", "TEXT", false, 0));
        _columnsDailyGoals.put("Body_Details_ID", new TableInfo.Column("Body_Details_ID", "TEXT", false, 0));
        _columnsDailyGoals.put("Food_Items_ID", new TableInfo.Column("Food_Items_ID", "TEXT", false, 0));
        _columnsDailyGoals.put("Exercise_ID", new TableInfo.Column("Exercise_ID", "TEXT", false, 0));
        _columnsDailyGoals.put("Goals_ID", new TableInfo.Column("Goals_ID", "TEXT", false, 0));
        _columnsDailyGoals.put("CalorieGoal", new TableInfo.Column("CalorieGoal", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDailyGoals = new HashSet<TableInfo.ForeignKey>(4);
        _foreignKeysDailyGoals.add(new TableInfo.ForeignKey("BodyDetails", "NO ACTION", "NO ACTION",Arrays.asList("Body_Details_ID"), Arrays.asList("Body Details ID")));
        _foreignKeysDailyGoals.add(new TableInfo.ForeignKey("Exercise", "NO ACTION", "NO ACTION",Arrays.asList("Exercise_ID"), Arrays.asList("Exercise ID")));
        _foreignKeysDailyGoals.add(new TableInfo.ForeignKey("FoodItems", "NO ACTION", "NO ACTION",Arrays.asList("Food_Items_ID"), Arrays.asList("Food Items ID")));
        _foreignKeysDailyGoals.add(new TableInfo.ForeignKey("Goals", "NO ACTION", "NO ACTION",Arrays.asList("Goals_ID"), Arrays.asList("Goals ID")));
        final HashSet<TableInfo.Index> _indicesDailyGoals = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDailyGoals = new TableInfo("DailyGoals", _columnsDailyGoals, _foreignKeysDailyGoals, _indicesDailyGoals);
        final TableInfo _existingDailyGoals = TableInfo.read(_db, "DailyGoals");
        if (! _infoDailyGoals.equals(_existingDailyGoals)) {
          throw new IllegalStateException("Migration didn't properly handle DailyGoals(com.example.IndustryProject.db.model.DailyGoals).\n"
                  + " Expected:\n" + _infoDailyGoals + "\n"
                  + " Found:\n" + _existingDailyGoals);
        }
        final HashMap<String, TableInfo.Column> _columnsBodyDetails = new HashMap<String, TableInfo.Column>(6);
        _columnsBodyDetails.put("Body Details ID", new TableInfo.Column("Body Details ID", "INTEGER", true, 1));
        _columnsBodyDetails.put("Age", new TableInfo.Column("Age", "TEXT", false, 0));
        _columnsBodyDetails.put("BMR", new TableInfo.Column("BMR", "TEXT", false, 0));
        _columnsBodyDetails.put("Lifestyle", new TableInfo.Column("Lifestyle", "TEXT", false, 0));
        _columnsBodyDetails.put("Weight", new TableInfo.Column("Weight", "TEXT", false, 0));
        _columnsBodyDetails.put("Height", new TableInfo.Column("Height", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBodyDetails = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBodyDetails = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBodyDetails = new TableInfo("BodyDetails", _columnsBodyDetails, _foreignKeysBodyDetails, _indicesBodyDetails);
        final TableInfo _existingBodyDetails = TableInfo.read(_db, "BodyDetails");
        if (! _infoBodyDetails.equals(_existingBodyDetails)) {
          throw new IllegalStateException("Migration didn't properly handle BodyDetails(com.example.IndustryProject.db.model.BodyDetails).\n"
                  + " Expected:\n" + _infoBodyDetails + "\n"
                  + " Found:\n" + _existingBodyDetails);
        }
      }
    }, "f2e70194da42251ecf358bc9853d4224", "98786cd958d2442dd159986351e1a605");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Users","Goals","FoodItems","Exercise","DailyGoals","BodyDetails");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `Users`");
      _db.execSQL("DELETE FROM `DailyGoals`");
      _db.execSQL("DELETE FROM `Goals`");
      _db.execSQL("DELETE FROM `FoodItems`");
      _db.execSQL("DELETE FROM `Exercise`");
      _db.execSQL("DELETE FROM `BodyDetails`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public DatabaseDao getDao() {
    if (_databaseDao != null) {
      return _databaseDao;
    } else {
      synchronized(this) {
        if(_databaseDao == null) {
          _databaseDao = new DatabaseDao_Impl(this);
        }
        return _databaseDao;
      }
    }
  }
}
