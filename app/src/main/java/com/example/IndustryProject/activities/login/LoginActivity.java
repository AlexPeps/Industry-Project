package com.example.IndustryProject.activities.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.IndustryProject.R;
import com.example.IndustryProject.activities.GoalsActivity;
import com.example.IndustryProject.db.entities.User;
import com.example.IndustryProject.db.viewModel.UserViewModel;
import com.example.IndustryProject.utils.SPApp;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUserName, edtPassword;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        edtUserName = findViewById(R.id.edt_user_name);
        edtPassword = findViewById(R.id.edt_password);
    }

    public void login(View view) {
        if (isEmpty(edtUserName)) {
            showError("User name is required");
            return;
        }
        if (isEmpty(edtPassword)) {
            showError("Password is required");
            return;
        }

        String name = edtUserName.getText().toString();
        userViewModel.getUser(name).observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                if (users.size() == 0) {
                    showError("User does not exist");
                    return;
                }
                checkPassword(users.get(0));
            }
        });

    }

    private void checkPassword(User user) {
        if (edtPassword.getText().toString().equals(user.getPassword())) {
            SPApp.saveUser(this, user);

            Intent intent = new Intent(this, GoalsActivity.class);
            startActivity(intent);
            finish();
        } else {
            showError("Password is wrong");
        }
    }
    public void register(View view) {
        Intent intent = new Intent(getApplicationContext(), AddUserActivity.class);
        startActivity(intent);
    }

    public boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }

    public void showError(String error) {
        Toast.makeText(this,
                error, Toast.LENGTH_LONG).show();
    }
}