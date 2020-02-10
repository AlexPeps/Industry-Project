package com.example.IndustryProject;

public class FoodSample {


    public String foodID;
    public String chapter;
    public String foodName;


    public FoodSample() {
        this.foodID = foodID;
        this.chapter = chapter;
        this.foodName = foodName;
    }




    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }



    @Override
    public String toString() {
        return "FoodSample{" +
                "foodID='" + foodID + '\'' +
                ", chapter='" + chapter + '\'' +
                ", foodName='" + foodName + '\'' +
                '}';
    }



}
