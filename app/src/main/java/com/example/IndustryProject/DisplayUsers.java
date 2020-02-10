package com.example.IndustryProject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.IndustryProject.db.dao.DatabaseDao;
import com.example.IndustryProject.db.model.User;

public class DisplayUsers extends AppCompatActivity {

    RecyclerView userList;
    public static DatabaseDao userDao;
    User user;
    public static final String USER_OBJECT= "USER_OBJECT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        user = (User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);


    }
}
















