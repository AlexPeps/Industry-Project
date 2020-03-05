package com.example.IndustryProject.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.IndustryProject.db.entities.FoodItems;
import com.example.IndustryProject.db.entities.Goals;
import com.example.IndustryProject.db.entities.User;

public class SPApp {

    private static String PREF_NAME = "pref_username";
    private static String PREF_FIRST_NAME = "pref_first_name";
    private static String PREF_LAST_NAME = "pref_last_name";
    private static String PREF_PHONE = "pref_phone";

    private static String PREF_STEP = "pref_step";
    private static String PREF_CALORIE = "pref_calorie";
    private static String PREF_TOTAL_CALS = "pref_total_cals";

    public static void saveUser(Context context, User user){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREF_NAME, user.getUserName());
        editor.putString(PREF_FIRST_NAME, user.getFirstName());
        editor.putString(PREF_LAST_NAME, user.getLastName());
        editor.putString(PREF_PHONE, user.getMobileNumber());
        editor.commit();
    }

    public static void saveGoals(Context context, Goals goals){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREF_STEP, goals.getStepGoal());
        editor.putString(PREF_CALORIE, goals.getCalorieGoal());
        editor.commit();
    }

    public static User getUser(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String name = prefs.getString(PREF_NAME, "");
        String firstName = prefs.getString(PREF_FIRST_NAME, "");
        String lastName = prefs.getString(PREF_LAST_NAME, "");
        String phone = prefs.getString(PREF_PHONE, "");

        User user = new User();
        user.setUserName(name);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMobileNumber(phone);
        return user;
    }

    public static Goals getGoals(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String step = prefs.getString(PREF_STEP, "");
        String calorie = prefs.getString(PREF_CALORIE, "");
        Goals goals = new Goals();
        goals.setCalorieGoal(calorie);
        goals.setStepGoal(step);
        return goals;
    }

    public static FoodItems getFoodItems(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String TotalCalories = prefs.getString(PREF_TOTAL_CALS, "");
        FoodItems foodItems = new FoodItems();
        foodItems.setCalories(TotalCalories);
        return foodItems;
    }
}
