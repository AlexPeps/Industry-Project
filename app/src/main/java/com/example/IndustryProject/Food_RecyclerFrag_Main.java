package com.example.IndustryProject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.IndustryProject.db.model.Goals;

public class Food_RecyclerFrag_Main  extends AppCompatActivity {
    //private boolean mSidePanel;

    Goals goals;

    public static float calRef1 = 0f;
    public static float user_fat1 = 0f;
    public static float user_carbs1 = 0f;
    public static float user_protein1 = 0f;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_frag_change_main);
        //Load common fragment
        if(savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction();
                 //   .replace(R.id.rcfrag_main, Food_RecyclerView_Main.newInstance()).commit();
        }

        calRef1 = Float.parseFloat(goals.getCalorieGoal().toString());

        //do fats carbs here etc




    }

}
