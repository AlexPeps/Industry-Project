package com.example.IndustryProject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.IndustryProject.db.entities.User;
import com.google.android.material.navigation.NavigationView;

public class Activity_ChangeGoal extends AppCompatActivity {
        //implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    User user;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_goal_settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);


        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Details saved", Toast.LENGTH_SHORT).show();
            }
        });


       // navigationView = (NavigationView) findViewById(R.id.navigation_view);
       // navigationView.setNavigationItemSelectedListener(this);


        View mHeaderView = navigationView.getHeaderView(0);

        TextView nameId = (TextView) mHeaderView.findViewById(R.id.txt1);
        nameId.setText(user.getFirstName());
        TextView emailId = (TextView) mHeaderView.findViewById(R.id.txt2);
        emailId.setText(user.getMobileNumber());

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        /*
        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer) {
                    @Override
                    public void onDrawerClosed(View drawerView) {
                        super.onDrawerClosed(drawerView);
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        super.onDrawerOpened(drawerView);
                    }
                };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.item1:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.item2:
                intent = new Intent(this, OverviewActivity.class);
                startActivity(intent);
                break;
            case R.id.item3:
                intent = new Intent(this, AccountActivity.class);
                startActivity(intent);
                break;
            case R.id.item4:
                Intent myIntent = new Intent(this, LoginActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// clear back stack
                startActivity(myIntent);
                finish();
            default:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    */

    }


}