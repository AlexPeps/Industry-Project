package com.example.IndustryProject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.IndustryProject.db.model.BodyDetails;

public class UpdateBodyDetailsActivity extends AppCompatActivity {

    public static final String BODY_OBJECT = "BODY_OBJECT";
    BodyDetails bodyDetails;
    public static final String USER_OBJECT= "USER_OBJECT";
    int updateResult, deleteResult;


    EditText age, bmr, weight, height;
    Spinner lifestyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_details);

        bodyDetails = (BodyDetails) getIntent().getSerializableExtra(UpdateBodyDetailsActivity.BODY_OBJECT);

        age = findViewById(R.id.et_age);
        bmr = findViewById(R.id.et_bmr);
        weight = findViewById(R.id.et_weight);
        height = findViewById(R.id.et_height);
        lifestyle = findViewById(R.id.sp_lifestyle);

        updateResult = -1;
        deleteResult = -1;

        setUIBehaviors();


    }

    private void setUIBehaviors(){

        age.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    // edit text is leaving the focus of the user
                    if(!age.getText().toString().equals(bodyDetails.getAge())){
                        // user has changed the info in the input field
                        bodyDetails.setAge(age.getText().toString());
                    }
                } else
                    age.selectAll();
            }
        });

        bmr.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    // edit text is leaving the focus of the user
                    if(!bmr.getText().toString().equals(bodyDetails.getBmr())){
                        // user has changed the info in the input field
                        bodyDetails.setBmr(age.getText().toString());
                    }
                } else
                    age.selectAll();
            }
        });



        weight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    // edit text is leaving the focus of the user
                    if(!weight.getText().toString().equals(bodyDetails.getWeight())){
                        // user has changed the info in the input field
                        bodyDetails.setWeight(weight.getText().toString());
                    }
                } else
                    age.selectAll();
            }
        });

        height.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    // edit text is leaving the focus of the user
                    if(!height.getText().toString().equals(bodyDetails.getHeight())){
                        // user has changed the info in the input field
                        bodyDetails.setHeight(height.getText().toString());
                    }
                } else
                    age.selectAll();
            }
        });

        lifestyle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(!lifestyle.getSelectedItem().toString().equals(bodyDetails.getLifestyle())){
                    bodyDetails.setLifestyle(lifestyle.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


    public class UpdateBody extends AsyncTask<BodyDetails, Void, Void> {

        @Override
        protected Void doInBackground(BodyDetails... bodyDetails) {
            updateResult = MainActivity.userDao.UpdateBody(bodyDetails[0]);
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

    public void updateBodyButtonClick(View view) { new UpdateBody().execute(bodyDetails);}

    public void stinfoCancelButtonClick(View view) {
        Intent backIntent = new Intent(getApplicationContext(),ProfileActivity.class);
        backIntent.putExtra(BODY_OBJECT, bodyDetails);
        startActivity(backIntent);

    }

}
