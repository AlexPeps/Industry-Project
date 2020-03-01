package com.example.IndustryProject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;



import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.IndustryProject.db.model.User;
import com.example.IndustryProject.utils.Constant;

public class UserInformationActivity extends AppCompatActivity {

    RecyclerView userList;

    User user;
    int updateResult, deleteResult;
    Button btnUpdate;
    EditText firstName, lastName, mobile, password;
    Spinner gender;

    public static final String USER_OBJECT= "USER_OBJECT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        user = (User) getIntent().getSerializableExtra(Constant.USER_OBJECT);

        updateResult = -1;
        deleteResult = -1;




        //userList = findViewById(R.id.user_list_recycler_view);



        initializeUI();
        setUIBehaviors();
    }

    private void initializeUI(){

        firstName = findViewById(R.id.et_stinfo_first_name);
        lastName = findViewById(R.id.et_stinfo_password);
        mobile = findViewById(R.id.et_stinfo_mobile);
        password = findViewById(R.id.et_stinfo_password);
        gender = findViewById(R.id.spinner_stinfo_gender);

        firstName.setText(user.getFirstName());
        lastName.setText(user.getFirstName());
        mobile.setText(user.getFirstName());
        password.setText(user.getFirstName());

        if(!gender.getSelectedItem().toString().equals(user.getGender())){
            gender.setSelection(1);
        }


    }


    private void setUIBehaviors(){

        firstName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    // edit text is leaving the focus of the user
                    if(!firstName.getText().toString().equals(user.getFirstName())){
                        // user has changed the info in the input field
                        user.setFirstName(firstName.getText().toString());
                    }
                } else
                    firstName.selectAll();
            }
        });

        lastName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    // edit text is leaving the focus of the user
                    if(!lastName.getText().toString().equals(user.getLastName())){
                        // user has changed the info in the input field
                        user.setLastName(firstName.getText().toString());
                    }
                } else
                    firstName.selectAll();
            }
        });



        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    // edit text is leaving the focus of the user
                    if(!password.getText().toString().equals(user.getPassword())){
                        // user has changed the info in the input field
                        user.setPassword(password.getText().toString());
                    }
                } else
                    firstName.selectAll();
            }
        });

        mobile.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    // edit text is leaving the focus of the user
                    if(!mobile.getText().toString().equals(user.getMobileNumber())){
                        // user has changed the info in the input field
                        user.setMobileNumber(mobile.getText().toString());
                    }
                } else
                    firstName.selectAll();
            }
        });

        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(!gender.getSelectedItem().toString().equals(user.getGender())){
                    user.setGender(gender.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }



    public void updateButtonClick(View view) { new UpdateUser().execute(user);}




    public void stinfoCancelButtonClick(View view) {
        Intent backIntent = new Intent(getApplicationContext(),ProfileActivity.class);
        backIntent.putExtra(USER_OBJECT, user);
        startActivity(backIntent);

    }






      /*  if (firstName.getText().toString().trim().isEmpty()
            && lastName.getText().toString().trim().isEmpty()
                && mobile.getText().toString().trim().isEmpty()
                && password.getText().toString().trim().isEmpty()) {
                    Toast.makeText(this, "Enter details to update", Toast.LENGTH_LONG).show();
        }

        else {

            User user = new User();
            user.setFirstName(firstName.getText().toString());
            user.setLastName(lastName.getText().toString());
            user.setPassword(password.getText().toString());
            user.setMobileNumber(mobile.getText().toString());
            user.setGender(gender.getSelectedItem().toString());
            UpdateUser updateUser = new UpdateUser();
            updateUser.execute(user);
        } */


    public class UpdateUser extends AsyncTask<User, Void, Void> {

        @Override
        protected Void doInBackground(User... users) {
            updateResult = MainActivity.userDao.updateUsers(users[0]);
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

