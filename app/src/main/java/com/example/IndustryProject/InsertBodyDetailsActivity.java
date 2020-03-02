package com.example.IndustryProject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.IndustryProject.db.AppDB;
import com.example.IndustryProject.db.model.BodyDetails;
import com.example.IndustryProject.db.model.Goals;
import com.example.IndustryProject.db.model.User;
import com.example.IndustryProject.utils.Constant;

public class InsertBodyDetailsActivity extends AppCompatActivity {


    User user;
    Goals goals;
    BodyDetails bodyDetails;
    public static final String USER_OBJECT= "USER_OBJECT";
    public static final String BODY_OBJECT= "BODY_OBJECT";
    long insertionResult;


    EditText age, bmr, weight, height;
    Spinner lifestyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_details);

        user = (User) getIntent().getSerializableExtra(Constant.USER_OBJECT);

        age = findViewById(R.id.et_age);
        bmr = findViewById(R.id.et_bmr);
        weight = findViewById(R.id.et_weight);
        height = findViewById(R.id.et_height);
        lifestyle = findViewById(R.id.sp_lifestyle);

        insertionResult = -1;


    }

    public void updateBodyButtonClick(View view) {

        if(age.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Age is required", Toast.LENGTH_LONG).show();
        } else if (bmr.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "BMR is required", Toast.LENGTH_LONG).show();

        }  else {

                BodyDetails bodyDetails = new BodyDetails();
                bodyDetails.setAge(age.getText().toString());
                bodyDetails.setBmr(age.getText().toString());
                bodyDetails.setWeight(weight.getText().toString());
                bodyDetails.setHeight(height.getText().toString());
                bodyDetails.setLifestyle(lifestyle.getSelectedItem().toString());


                InsertBodyDetails insertBodyDetails = new InsertBodyDetails();
                insertBodyDetails.execute(bodyDetails);

                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(BODY_OBJECT, bodyDetails);
                intent.putExtra(USER_OBJECT, user);
                startActivity(intent);

            }

    }



    public class InsertBodyDetails extends AsyncTask<BodyDetails, Void, Void> {



        @Override
        protected Void doInBackground(BodyDetails... bodyDetails) {
           // insertionResult = MainActivity.userDao.insertBodyDetails(bodyDetails[0]);
            insertionResult = AppDB.instance().getDao().insertBodyDetails(bodyDetails[0]);
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



    public void stinfoCancelButtonClick(View view) {
        Intent backIntent = new Intent(getApplicationContext(),ProfileActivity.class);
        backIntent.putExtra(Constant.USER_OBJECT, user);
        backIntent.putExtra(Constant.GOALS_OBJECT, goals);
        backIntent.putExtra(Constant.BODY_OBJECT, bodyDetails);
        startActivity(backIntent);

    }



}
