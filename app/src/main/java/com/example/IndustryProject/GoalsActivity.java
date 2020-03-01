package com.example.IndustryProject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.IndustryProject.db.AppDB;
import com.example.IndustryProject.db.model.BodyDetails;
import com.example.IndustryProject.db.model.Goals;
import com.example.IndustryProject.db.model.User;
import com.example.IndustryProject.utils.Constant;

public class GoalsActivity extends AppCompatActivity {

    User user;
    Goals goals;
    long insertionResult;
    EditText etStepGoal, etCalorieGoal;
    public static float mSeries = 0f;
    public static float mSeries1 = 0f;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_activity);

        user = (User) getIntent().getSerializableExtra(Constant.USER_OBJECT);
        goals = (Goals) getIntent().getSerializableExtra(Constant.GOALS_OBJECT);
        BodyDetails body = (BodyDetails) getIntent().getSerializableExtra(Constant.BODY_OBJECT);

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

            if(goals == null) {

                Intent intent = new Intent(getApplicationContext(), InsertBodyDetailsActivity.class);
                intent.putExtra(Constant.GOALS_OBJECT, goals);
                intent.putExtra(Constant.USER_OBJECT, user);
                startActivity(intent);

            }else{

                Intent profileIntent = new Intent(getApplicationContext(), ProfileActivity.class);
                profileIntent.putExtra(Constant.GOALS_OBJECT, goals);
                profileIntent.putExtra(Constant.USER_OBJECT, user);
                startActivity(profileIntent);


            }



        }


    }

    public class InsertGoals extends AsyncTask<Goals, Void, Void> {

        @Override
        protected Void doInBackground(Goals... goals) {
           // insertionResult = MainActivity.userDao.insertGoals(goals[0]);
            insertionResult = AppDB.instance().getDao().insertGoals(goals[0]);
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
