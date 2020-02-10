package com.example.IndustryProject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.IndustryProject.db.model.BodyDetails;
import com.example.IndustryProject.db.model.Goals;
import com.example.IndustryProject.db.model.User;

public class GoalsActivity extends AppCompatActivity {

    User user;
    Goals goals;
    long insertionResult;
    EditText etStepGoal, etCalorieGoal;
    public static float mSeries = 0f;
    public static float mSeries1 = 0f;
    public static final String GOALS_OBJECT= "GOALS_OBJECT";
    public static final String USER_OBJECT= "USER_OBJECT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_activity);

        user = (User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);
        goals = (Goals) getIntent().getSerializableExtra(GoalsActivity.GOALS_OBJECT);
        BodyDetails body = (BodyDetails) getIntent().getSerializableExtra(InsertBodyDetailsActivity.BODY_OBJECT);

        insertionResult = -1;


        etStepGoal = findViewById(R.id.et1);
        etCalorieGoal = findViewById(R.id.et2);
        Button setgoal = findViewById(R.id.setgoal);

        //setUIBehaviors();




    }


    public void btnSetGoalsClick(View view) {


        if (etStepGoal.getText().toString().trim().isEmpty()) {
            etStepGoal.setError("Set Steps Goal");
            return;
        } else if (etCalorieGoal.getText().toString().trim().isEmpty()) {
            etCalorieGoal.setError("Set Calorie Goal!");
            return;
        } else {

            //create new goals object
            Goals goals = new Goals();
            goals.setStepGoal(etStepGoal.getText().toString());
            mSeries = Float.parseFloat(etStepGoal.getText().toString());

            goals.setCalorieGoal(etCalorieGoal.getText().toString());
            mSeries1 = Float.parseFloat(etCalorieGoal.getText().toString());

            InsertGoals insertGoals = new InsertGoals();
            insertGoals.execute(goals);

            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            intent.putExtra(GOALS_OBJECT, goals);
            intent.putExtra(USER_OBJECT, user);
            startActivity(intent);



        }


    }

    public class InsertGoals extends AsyncTask<Goals, Void, Void> {

        @Override
        protected Void doInBackground(Goals... goals) {
            insertionResult = MainActivity.userDao.insertGoals(goals[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (insertionResult == -1) {
                Toast.makeText(getApplicationContext(),
                        "Update failure.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Update Success. User ID: " + insertionResult, Toast.LENGTH_LONG).show();

            }

        }
    }
}