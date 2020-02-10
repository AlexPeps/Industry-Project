package com.example.IndustryProject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class FoodSummaryActivity extends AppCompatActivity {


    public static float stepMax = 0f;
    public static float calorieMax = 0f;
    float food_calories;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_summary);


        //food_calories = Food_MyRecyclerViewAdapter.caloriecount;
        Log.d("Calories for Overview", String.valueOf(Food_RecyclerFrag_Main.calRef1));
        // Setting Steps and Calories
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
        final CircleProgressBar steps = (CircleProgressBar) findViewById(R.id.step_progress);
        final CircleProgressBar food = (CircleProgressBar) findViewById(R.id.food_progress);

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
        if (food_calories > 0) {
            food.setProgress((100 * (food_calories)) / calorieMax);
            food.setText(food_calories + "/ " + calorieMax);
        } else {
            food.setProgress((100 * (MainActivity.calRef)) / calorieMax);
            food.setText(MainActivity.calRef + "/ " + calorieMax);
        }
        food.setWidth(200);
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


        // On Touch Listeners for Image animations
/*
        food_summary.setOnTouchListener(new View.OnTouchListener() {
            private Rect rect;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    food_summary.setColorFilter(Color.argb(31, 58, 147, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    food_summary.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    if(!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())){
                        food_summary.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });

        share_a_run.setOnTouchListener(new View.OnTouchListener() {
            private Rect rect;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    share_a_run.setColorFilter(Color.argb(31, 58, 147, 0));
                    rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    share_a_run.setColorFilter(Color.argb(0, 0, 0, 0));
                }
                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    if(!rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())){
                        share_a_run.setColorFilter(Color.argb(0, 0, 0, 0));
                    }
                }
                return false;
            }
        });
*/
        // Add Calories
        ImageView addcal = (ImageView) findViewById(R.id.addcalories);
        addcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FoodSummaryActivity.this, Food_RecyclerFrag_Main.class);
                startActivity(intent1);
            }
        });

//        Firebase ref = new Firebase("https://healthkit.firebaseio.com/Calories");
//        Query queryRef = ref.child(LoginActivity.USER_ID).orderByChild("steps");
//
//        queryRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot snapshot, String previousChild) {
//                String facts = (String) snapshot.getValue();
//                System.out.println(snapshot.getKey() + " was " + facts + " meters tall");
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
    }



}
