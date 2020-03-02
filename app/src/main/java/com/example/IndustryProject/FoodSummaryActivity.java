package com.example.IndustryProject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.IndustryProject.db.AppDB;
import com.example.IndustryProject.db.dao.DatabaseDao;
import com.example.IndustryProject.db.model.BodyDetails;
import com.example.IndustryProject.db.model.FoodItems;
import com.example.IndustryProject.db.model.Goals;
import com.example.IndustryProject.db.model.User;
import com.example.IndustryProject.utils.Constant;
import com.google.android.material.navigation.NavigationView;
import com.natasa.progressviews.CircleProgressBar;
import com.natasa.progressviews.utils.OnProgressViewListener;

import java.util.List;

public class FoodSummaryActivity extends AppCompatActivity {


    public static float stepMax = 0f;
    public static float calorieMax = 0f;

    public static String clearGoal = " ";
    float food_calories;
    FoodItems foodItems;
    BodyDetails bodyDetails;
    DatabaseDao databaseDao;
    int updateResult;
    Goals goals;
    User user;
    Toolbar toolbar;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_summary);

<<<<<<< HEAD


        food_calories =  SearchActivity.calRef;


        goals = (Goals) getIntent().getSerializableExtra(Constant.GOALS_OBJECT);
        user = (User) getIntent().getSerializableExtra(Constant.USER_OBJECT);
        bodyDetails = (BodyDetails) getIntent().getSerializableExtra(Constant.BODY_OBJECT);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class );
                intent.putExtra(Constant.FOOD_OBJECT, foodItems);
                intent.putExtra(Constant.USER_OBJECT, user);
                startActivity(intent);

            }
        });


        updateResult = -1;

      //  getUserInfo();
=======
<<<<<<< HEAD
<<<<<<< HEAD
        food_calories = ProfileActivity.calRef;


=======
        food_calories = MainActivity.calRef;
>>>>>>> parent of 3a9383a... 1/3


=======
        food_calories = MainActivity.calRef;


>>>>>>> parent of 3a9383a... 1/3
>>>>>>> 0825efebb9ee8aa30bdbd67c21f4c61bbbd5eaeb



        Log.d("Calories for Overview", String.valueOf(Food_RecyclerFrag_Main.calRef1));
        // Setting Steps and CaloriesFood_RecyclerFrag_Main
        stepMax = GoalsActivity.mSeries;
        if (stepMax == 0) {
            stepMax = GoalsActivity.mSeries1;
        }
        calorieMax = GoalsActivity.mSeries1;
        /*

        Log.d("SetGoal mseries", String.valueOf(GoalsActivity.mSeries));
        if (calorieMax == 0) {
            calorieMax = GoalsActivity.mSeries2;
        }

         */
        final CircleProgressBar steps = findViewById(R.id.step_progress);
        final CircleProgressBar food = findViewById(R.id.food_progress);

        // Animation
        TranslateAnimation translation;
        translation = new TranslateAnimation(0f, 0F, 0f, 180);
        translation.setStartOffset(100);
        translation.setDuration(2000);
        translation.setFillAfter(true);
        translation.setInterpolator(new BounceInterpolator());

        TranslateAnimation translation1;
        translation1 = new TranslateAnimation(0f, 0F, 0f, 220);
        translation1.setStartOffset(100);
        translation1.setDuration(2000);
        translation1.setFillAfter(true);
        translation1.setInterpolator(new BounceInterpolator());

        // Steps Progress Bar
        steps.setProgress((100 * (ProfileActivity.evsteps)) / stepMax);
        steps.setWidth(280);
        steps.setWidthProgressBackground(25);
        steps.setWidthProgressBarLine(20);
        steps.setText(ProfileActivity.evsteps + "/ " + stepMax);
        steps.setTextSize(40);
        steps.setBackgroundColor(Color.LTGRAY);
        steps.setRoundEdgeProgress(true);
        steps.startAnimation(translation);
        //steps.setProgressIndeterminateAnimation(1000);
        // Food Progress Bar
        /*
        if (food_calories > 0) {
            food.setProgress((100 * (food_calories)) / calorieMax);
            food.setText(food_calories + "/ " + calorieMax);
        } else {
            food.setProgress((100 * (MainActivity.calRef)) / calorieMax);
            food.setText(MainActivity.calRef + "/ " + calorieMax);
        }

         */
        food.setProgress((100 * (food_calories /calorieMax)));
        food.setText(food_calories + "/ " + calorieMax);
        food.setWidthProgressBackground(25);
        food.setWidthProgressBarLine(40);
        food.setTextSize(70);
        food.setBackgroundColor(Color.LTGRAY);
        food.setRoundEdgeProgress(true);
        food.setAnimation(translation1);
        //food.setProgressIndeterminateAnimation(2000);

        // Listeners
        steps.setOnProgressViewListener(new OnProgressViewListener() {
            float progress = 0;

            @Override
            public void onFinish() {
                //do something on progress finish
                //steps.setText("done!");
                // circleProgressBar.resetProgressBar();
            }

            @Override
            public void onProgressUpdate(float prog) {
                steps.setText("" + (int) prog);
                setProgress(prog);
            }

            @Override
            public void setProgress(float prog) {
                progress = prog;
            }

            @Override
            public int getprogress() {
                return (int) progress;
            }
        });

        food.setOnProgressViewListener(new OnProgressViewListener() {
            float progress = 0;

            @Override
            public void onFinish() {
                //do something on progress finish
                //food.setText("d");
                // circleProgressBar.resetProgressBar();
            }

            @Override
            public void onProgressUpdate(float progress) {
                food.setText("" + (int) progress);
                setProgress(progress);
            }

            @Override
            public void setProgress(float prog) {
                progress = prog;
            }

            @Override
            public int getprogress() {
                return (int) progress;
            }
        });


        // On Click Listeners for Activities
        final ImageView food_summary = (ImageView) findViewById(R.id.food_summary);
        food_summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodSummaryActivity.this, FoodSummaryActivity.class);
                startActivity(intent);
            }
        });



        // Add Calories
        ImageView addcal = (ImageView) findViewById(R.id.addcalories);
        addcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), SearchActivity.class);
                intent1.putExtra(Constant.FOOD_OBJECT, foodItems);
                intent1.putExtra(Constant.BODY_OBJECT, bodyDetails);
                intent1.putExtra(Constant.GOALS_OBJECT, goals);
                intent1.putExtra(Constant.USER_OBJECT, user);
                startActivity(intent1);
            }
        });


    }

    public void resetGoalsClick(View view) {

        final AlertDialog alertDialog = new AlertDialog.Builder(FoodSummaryActivity.this).create();
        alertDialog.setTitle("Reset Daily goals?");
        alertDialog.setIcon(R.drawable.ic_pizza);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }
        );

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        if (goals.getCalorieGoal().isEmpty()){

                            Toast.makeText(getApplicationContext(),"No goals entered!", Toast.LENGTH_SHORT);

                        } else{
                            stepMax = 0;
                            calorieMax = 0;
                            goals.calorieGoal = clearGoal;
                            goals.stepGoal = clearGoal;
                        new UpdateGoals().execute(goals);
                        dialog.dismiss();
                    }}

                });
        alertDialog.show();
    }

    public void foodEditClick(View view) {

        Intent foodIntent = new Intent(getApplicationContext(),SearchActivity.class);
        foodIntent.putExtra(Constant.FOOD_OBJECT, foodItems);
        foodIntent.putExtra(Constant.BODY_OBJECT, bodyDetails);
        foodIntent.putExtra(Constant.USER_OBJECT, user);
    }

    public void foodBreakDownClick(View view) {

        Intent intent2 = new Intent(FoodSummaryActivity.this, FoodBreakdownActivity.class);
        intent2.putExtra(Constant.FOOD_OBJECT, foodItems);
        startActivity(intent2);

    }

    public class UpdateGoals extends AsyncTask<Goals, Void, Void> {

        @Override
        protected Void doInBackground(Goals... goals) {
            updateResult = AppDB.instance().getDao().updateGoals(goals[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (updateResult == -1) {
                Toast.makeText(getApplicationContext(),
                        "Update failure.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Update Success. User ID: " + updateResult, Toast.LENGTH_LONG).show();

            }

        }
    }


}
