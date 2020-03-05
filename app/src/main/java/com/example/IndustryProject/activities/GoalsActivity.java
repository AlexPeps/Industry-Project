package com.example.IndustryProject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.IndustryProject.R;
import com.example.IndustryProject.db.entities.Goals;
import com.example.IndustryProject.db.viewModel.GoalViewModel;
import com.example.IndustryProject.utils.Constant;
import com.example.IndustryProject.utils.SPApp;

public class GoalsActivity extends AppCompatActivity {

    private EditText etStepGoal, etCalorieGoal;
    private GoalViewModel goalViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals_activity);

        goalViewModel = ViewModelProviders.of(this).get(GoalViewModel.class);

        etStepGoal = findViewById(R.id.et1);
        etCalorieGoal = findViewById(R.id.et2);
    }


    public void btnSetGoalsClick(View view) {
        if (etStepGoal.getText().toString().trim().isEmpty()) {
            etStepGoal.setError("Set Steps Goal");
            return;
        }

        if (etCalorieGoal.getText().toString().trim().isEmpty()) {
            etCalorieGoal.setError("Set Calorie Goal!");
            return;
        }

        Goals goals = new Goals();
        goals.setStepGoal(etStepGoal.getText().toString());
        goals.setCalorieGoal(etCalorieGoal.getText().toString());

        SPApp.saveGoals(this, goals);
        goalViewModel.insert(goals);
        Intent profileIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(profileIntent);
    }
}
