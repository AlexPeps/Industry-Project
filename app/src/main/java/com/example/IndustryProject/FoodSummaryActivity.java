package com.example.IndustryProject;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.IndustryProject.activities.GoalsActivity;
import com.example.IndustryProject.activities.MainActivity;
import com.example.IndustryProject.db.entities.BodyDetails;
import com.example.IndustryProject.db.entities.FoodItems;
import com.example.IndustryProject.db.entities.Goals;
import com.example.IndustryProject.db.entities.User;
import com.example.IndustryProject.db.viewModel.FoodViewModel;
import com.example.IndustryProject.utils.Constant;
import com.example.IndustryProject.utils.SPApp;
import com.natasa.progressviews.CircleProgressBar;
import com.natasa.progressviews.utils.OnProgressViewListener;

import java.util.List;

public class FoodSummaryActivity extends AppCompatActivity {
    public static float stepMax = 0f;
    public static float calorieMax = 0f;
    public static float calRef = 0f;
    //public static String clearGoal = " ";
    float food_calories;
    FoodItems foodItems;
    BodyDetails bodyDetails;
    Goals goals;
    User user;
    Toolbar toolbar;

    private int evsteps;
    private FoodViewModel foodViewModel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_summary);
        foodViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Food Summary");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        goals = SPApp.getGoals(this);
        user = (User) getIntent().getSerializableExtra(Constant.USER_OBJECT);
        foodItems = SPApp.getFoodItems(this);
        evsteps = getIntent().getIntExtra(Constant.EVSTEP, 0);

        getUserInfo();
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        calRef = 0;
        return true;
    }

    private void updateUI(){
        food_calories = calRef;
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

        stepMax = Float.parseFloat(goals.getStepGoal());
        // Steps Progress Bar
        steps.setProgress((100 * evsteps) / stepMax);
        steps.setWidth(280);
        steps.setWidthProgressBackground(25);
        steps.setWidthProgressBarLine(20);
        steps.setText(evsteps + "/ " + stepMax);
        steps.setTextSize(40);
        steps.setBackgroundColor(Color.LTGRAY);
        steps.setRoundEdgeProgress(true);
        steps.startAnimation(translation);

        calorieMax = Float.parseFloat(goals.getCalorieGoal());
        food.setProgress((100 * (food_calories / calorieMax)));
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

/*
        // On Click Listeners for Activities
        final ImageView food_summary = (ImageView) findViewById(R.id.food_summary);
        food_summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodSummaryActivity.this, FoodSummaryActivity.class);
                startActivity(intent);
            }
        });


*/
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

    private void getUserInfo() {
            foodViewModel.getAllFoodItems().observe(this, new Observer<List<FoodItems>>() {
                @Override
                public void onChanged(List<FoodItems> foodItems) {
                    for (FoodItems food : foodItems) {
                        //set calories to be displayed in overview page
                        calRef += Float.parseFloat(food.getCalories());
                        updateUI();
                    }
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


                        final CircleProgressBar steps = findViewById(R.id.step_progress);
                        final CircleProgressBar food = findViewById(R.id.food_progress);


                       // goals.setCalorieGoal(clearGoal);
                        //goals.setStepGoal(clearGoal);
                        foodViewModel.delete(foodItems);

                        Intent GoalIntent = new Intent(getApplicationContext(), GoalsActivity.class);
                        GoalIntent.putExtra(Constant.FOOD_OBJECT, foodItems);
                        GoalIntent.putExtra(Constant.BODY_OBJECT, bodyDetails);
                        GoalIntent.putExtra(Constant.USER_OBJECT, user);
                        GoalIntent.putExtra(Constant.GOALS_OBJECT, goals);
                        startActivity(GoalIntent);


                    }

                });
        alertDialog.show();
    }

    public void foodEditClick(View view) {
        Intent foodIntent = new Intent(getApplicationContext(), SearchActivity.class);
        foodIntent.putExtra(Constant.FOOD_OBJECT, foodItems);
        foodIntent.putExtra(Constant.BODY_OBJECT, bodyDetails);
        foodIntent.putExtra(Constant.USER_OBJECT, user);
    }

    public void foodBreakDownClick(View view) {
        Intent intent2 = new Intent(getApplicationContext(), FoodBreakdownActivity.class);
        intent2.putExtra(Constant.FOOD_OBJECT, foodItems);
        startActivity(intent2);

    }
}



