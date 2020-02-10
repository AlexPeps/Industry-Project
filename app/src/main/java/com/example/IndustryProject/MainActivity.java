package com.example.IndustryProject;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.IndustryProject.db.dao.DatabaseDao;
import com.example.IndustryProject.db.AppDB;
import com.example.IndustryProject.db.model.User;


import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {


    public static final String GOALS_OBJECT = "GOALS_OBJECT";
    public static DatabaseDao userDao;
    EditText TextEnterUsername, TextEnterPassword;
    public static final String USER_OBJECT= "USER_OBJECT";
    public static float mSeries1 = 0f;
    public static float mSeries2 = 0f;
    public static float calRef = 0f;
    public static float user_fat = 0f;
    public static float user_carbs = 0f;
    public static float user_protein = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDao = AppDB.createAppDBInstance(this).getDao();
        TextEnterUsername = findViewById(R.id.TextEnterUsername);
        TextEnterPassword = findViewById(R.id.TextEnterPassword);

        //List<Student> list = userDao.readAllStudents();

//        Toast.makeText(this, "Students read from DB " + list.size(),
//                Toast.LENGTH_LONG).show();

    }

    public void mainActivityCancelButtonClick(View view) {
        finish();
    }

    public void onViewClicked(View view) {
        Intent intent = new Intent(getApplicationContext(), AddUserAcitivity.class);
        startActivity(intent);
    }

    public void loginButtonClick(View view) {
        if(TextEnterUsername.getText().toString().trim().isEmpty()){
            Toast.makeText(this,
                    "User name is required", Toast.LENGTH_LONG).show();
        } else if(TextEnterPassword.getText().toString().trim().isEmpty()){
            Toast.makeText(this,
                    "Password is required", Toast.LENGTH_LONG).show();
        } else {
            new ReadUserByUName().execute(TextEnterUsername.getText().toString());
        }
    }

    private void checkPassword(User user){
        if(TextEnterPassword.getText().toString().equals(user.getPassword())){
            Intent intent = new Intent(this, GoalsActivity.class);
            intent.putExtra(USER_OBJECT, user);
            startActivity(intent);
        } else {
            Toast.makeText(this,
                    "Password is wrong", Toast.LENGTH_LONG).show();
        }
    }

/*    public void listViewButtonClicked(View view) {
        Intent intent = new Intent(this, StudentListActivity.class);
        startActivity(intent);
    } */

    private class ReadUserByUName extends AsyncTask<String, Void, Void>{
        List<User> users = null;
        @Override
        protected Void doInBackground(String... strings) {
            users = userDao.searchUserByUserName(strings[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(users == null){
                Toast.makeText(getApplicationContext(),
                        "Read Operation Failure", Toast.LENGTH_LONG).show();
            } else if (users.size() == 0){
                Toast.makeText(getApplicationContext(),
                        "User does not exist", Toast.LENGTH_LONG).show();
            } else {
                checkPassword(users.get(0));
            }
        }
    }
}