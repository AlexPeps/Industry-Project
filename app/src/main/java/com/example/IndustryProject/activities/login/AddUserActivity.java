package com.example.IndustryProject.activities.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.IndustryProject.R;
import com.example.IndustryProject.db.entities.User;
import com.example.IndustryProject.db.viewModel.UserViewModel;


public class AddUserActivity extends AppCompatActivity {
    private EditText etStFName, etStLName, etStUName, etStPassword, etStMobile, etStAddress;
    private Spinner spGender;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_acitivity);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        etStFName = findViewById(R.id.textFirstName);
        etStLName = findViewById(R.id.textLastName);
        etStUName = findViewById(R.id.et_reg_user_name);
        etStPassword = findViewById(R.id.textInputPassword);
        etStMobile = findViewById(R.id.textPhoneNo);
        etStAddress = findViewById(R.id.textAddress);
        spGender = findViewById(R.id.spinner_reg_gender);

    }
    public void addUser(View view) {
        if (etStFName.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "First Name is required", Toast.LENGTH_LONG).show();
        } else if (etStLName.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Last Name is required", Toast.LENGTH_LONG).show();
        } else if (etStUName.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "User Name is required", Toast.LENGTH_LONG).show();
        } else if (etStPassword.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_LONG).show();
        } else if (etStMobile.getText().toString().trim().isEmpty()) {
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
            user.setAddress(etStAddress.getText().toString());

            userViewModel.insert(user);

            Toast.makeText(this, "Insert Success", Toast.LENGTH_LONG).show();
            finishActivity();
        }
    }

    public void cancel(View view) {
        finishActivity();
    }

    private void finishActivity() {
        finish();
    }
}