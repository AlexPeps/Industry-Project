package com.example.IndustryProject.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "BodyDetails")
public class BodyDetails implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Body Details ID")
    public int BID;

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

    public void setBID(int BID) {this.BID = BID;}

    public void setAge (String age) {
        this.age = age;
    }

    public void setBmr (String bmr) {
        this.bmr = bmr;
    }

    public void setLifestyle (String lifestyle) {
        this.lifestyle = lifestyle;
    }

    public void setWeight (String weight) {this.weight = weight; }

    public void setHeight (String height) {
        this.height = height;
    }

    public int getBID (){return BID;}

    public String getAge (){return age;}

    public String getBmr (){return bmr;}

    public String getLifestyle (){return lifestyle;}

    public String getWeight (){return weight;}

    public String getHeight (){return height;}
}
