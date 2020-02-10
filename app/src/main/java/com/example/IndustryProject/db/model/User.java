package com.example.IndustryProject.db.model;

import com.example.IndustryProject.utils.DateConverter;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;


@Entity(tableName = "Users")

@TypeConverters({DateConverter.class})
public class User implements Serializable {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "User ID")
    public int SID;

    @ColumnInfo(name = "First Name")
    public String firstName;

    @ColumnInfo(name = "Last Name")
    public String lastName;

    @ColumnInfo(name = "user_Name")
    public String userName;

    @ColumnInfo(name = "Password")
    public String password;

    @ColumnInfo(name = "Address")
    public String address;

    @ColumnInfo(name = "Gender")
    public String gender;

    @ColumnInfo(name = "Mobile Number")
    public String mobileNumber;

    //Goal details

    @ColumnInfo(name = "Step Goal")
    public String stepGoal;

    @ColumnInfo(name = "CalorieGoal")
    public String calorieGoal;




    //body details


    @ColumnInfo(name = "Age")
    public String age;

    @ColumnInfo(name = "BMR")
    public String bmr;

    @ColumnInfo(name = "Lifestyle")
    public String lifestyle;

    @ColumnInfo(name = "Weight")
    public String weight;

    @ColumnInfo(name = "Height")
    public String height;







    //user setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String Address) {this.address = address;}

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }



    public int getSID() {
        return SID;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {return address;}

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }





}