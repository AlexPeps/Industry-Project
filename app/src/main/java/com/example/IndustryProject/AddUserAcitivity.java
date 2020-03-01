package com.example.IndustryProject;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.IndustryProject.db.model.User;


import androidx.appcompat.app.AppCompatActivity;


public class AddUserAcitivity extends AppCompatActivity {



    long insertionResult;
    EditText etStFName,etStLName, etStUName, etStPassword, etStMobile,etStAddress;
    Spinner spGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_acitivity);

        insertionResult = -1;
        etStFName = findViewById(R.id.textFirstName);
        etStLName = findViewById(R.id.textLastName);
        etStUName = findViewById(R.id.et_reg_user_name);
        etStPassword = findViewById(R.id.textInputPassword);
        etStMobile = findViewById(R.id.textPhoneNo);
        etStAddress = findViewById(R.id.textAddress);
        spGender = findViewById(R.id.spinner_reg_gender);

    }

    public void cancelRegistrationButtonClick(View view) {
        finishActivity();
    }

    private void finishActivity(){
        finish();
    }

    public void userRegisterButtonClick(View view) {
        if(etStFName.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "First Name is required", Toast.LENGTH_LONG).show();
        } else if (etStLName.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Last Name is required", Toast.LENGTH_LONG).show();
        } else if(etStUName.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "User Name is required", Toast.LENGTH_LONG).show();
        } else if(etStPassword.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Password is required", Toast.LENGTH_LONG).show();
        } else if(etStMobile.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Mobile Number is required", Toast.LENGTH_LONG).show();
        } else {
            // we going create a user object and fill all these info in the object
            User user = new User();
            user.setFirstName(etStFName.getText().toString());
            user.setLastName(etStLName.getText().toString());
            user.setUserName(etStUName.getText().toString());
            user.setPassword(etStPassword.getText().toString());
            user.setMobileNumber(etStMobile.getText().toString());
            user.setGender(spGender.getSelectedItem().toString());
            InsertUser insertUser = new InsertUser();
            insertUser.execute(user);
        }
    }

    public void btn_cancel_add_user(View view) {
        finishActivity();
    }

    public class InsertUser extends AsyncTask<User, Void, Void> {

        @Override
        protected Void doInBackground(User... users) {
            insertionResult = MainActivity.userDao.insertUsers(users[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(insertionResult == -1){
                Toast.makeText(getApplicationContext(),
                        "Insertion failure.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Insertion Success. User ID: " + insertionResult, Toast.LENGTH_LONG).show();
                finishActivity();
            }
        }
    }



}