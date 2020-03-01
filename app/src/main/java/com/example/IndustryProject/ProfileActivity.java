package com.example.IndustryProject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

<<<<<<< HEAD
=======
import com.example.IndustryProject.db.AppDB;
>>>>>>> 3a9383a5efb0827f3476168cf027c462fd6f8c41
import com.example.IndustryProject.db.dao.DatabaseDao;
import com.example.IndustryProject.db.model.BodyDetails;
import com.example.IndustryProject.db.model.FoodItems;
import com.example.IndustryProject.db.model.Goals;
import com.example.IndustryProject.db.model.User;
import com.example.IndustryProject.utils.Constant;
import com.google.android.material.navigation.NavigationView;
import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.DecoDrawEffect;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.events.DecoEvent;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.List;


public class ProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SensorEventListener {


    public static float evsteps;
    public static float calRef1 = 0f;
    public static int cont = 0;
    public static float mSeriesMax = 0f;
    public static DatabaseDao userDao;
    public static float calRef = 0f;
    boolean activityRunning;
    Goals goals;
    TextView firstName, lastName, mobile, userName, name, age, bmr, lifestyle, weight, height;
    ImageView image;
    User user;
    FoodItems foodItems;
    BodyDetails bodyDetails;
    FoodItems foodItems;
    private DecoView mDecoView;
    private TextView textView;
    private int mBackIndex;
    private int mSeries1Index;
    private SensorManager sensorManager;
    int updateResult;





    DrawerLayout drawerLayout;

    Toolbar toolbar;
    int deleteResult;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);


<<<<<<< HEAD

        user = (User) getIntent().getSerializableExtra(MainActivity.USER_OBJECT);
        user = (User) getIntent().getSerializableExtra(SearchActivity.USER_OBJECT);
        goals = (Goals) getIntent().getSerializableExtra(MainActivity.GOALS_OBJECT);
        bodyDetails = (BodyDetails) getIntent().getSerializableExtra(UpdateBodyDetailsActivity.BODY_OBJECT);
        foodItems = (FoodItems) getIntent().getSerializableExtra(SearchActivity.FOOD_OBJECT);
=======
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        user = (User) getIntent().getSerializableExtra(Constant.USER_OBJECT);
        goals = (Goals) getIntent().getSerializableExtra(Constant.GOALS_OBJECT);
        bodyDetails = (BodyDetails) getIntent().getSerializableExtra(Constant.BODY_OBJECT);
        foodItems = (FoodItems) getIntent().getSerializableExtra(Constant.FOOD_OBJECT);
>>>>>>> 3a9383a5efb0827f3476168cf027c462fd6f8c41

        updateResult = -1;
        deleteResult = -1;


        mSeriesMax = GoalsActivity.mSeries;

        //get mseries from goals


        Log.d("SetGoal mseries", String.valueOf(GoalsActivity.mSeries));
        if (mSeriesMax == 0) {

            mSeriesMax = Float.parseFloat(goals.getStepGoal().toString());
        }


        mDecoView = (DecoView) findViewById(R.id.dynamicArcView);
        /**
         * Data series index used for controlling animation of {@link DecoView}. These are set when
         * the data series is created then used in {@link #createEvents} to specify what series to
         * apply a given event to
         */

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Go to data image button
        final ImageView dn = (ImageView) findViewById(R.id.datanext);
        // Go to Chart Data page
        dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ProfileActivity.this, SearchActivity.class);
                intent1.putExtra(Constant.FOOD_OBJECT, foodItems);
                intent1.putExtra(Constant.BODY_OBJECT, bodyDetails);
                intent1.putExtra(Constant.USER_OBJECT, user);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(ProfileActivity.this, v, "testAnimation");
                    ProfileActivity.this.startActivity(intent1, options.toBundle());
                } else {
                    startActivity(intent1);
                }
            }
        });

        Log.d("mSeries out", (String.valueOf(mSeriesMax)));
        if (mSeriesMax > 0) {
            Log.d("mSeries out in", (String.valueOf(mSeriesMax)));
            // Create required data series on the DecoView
            createBackSeries();
            createDataSeries1();

            // Setup events to be fired on a schedule
            createEvents();
        }

        //action bar

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_24px);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_24px);

        new DrawerBuilder().withActivity(this).build();


        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                //.withHeaderBackground(R.drawable.header)
                .addProfiles(


                        new ProfileDrawerItem().withName(user.getFirstName() + " " + user.getLastName()).withEmail(user.getMobileNumber()).withIcon(getDrawable(R.drawable.ic_pizza)


                        )


                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })

                .build();


        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Update Account Details").withIcon(getResources().getDrawable(R.drawable.ic_pizza));
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("Update Body Details").withIcon(getResources().getDrawable(R.drawable.ic_account_box_24px));
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("Delete Account").withIcon(getResources().getDrawable(R.drawable.ic_delete_24px));
        SecondaryDrawerItem item4 = new SecondaryDrawerItem().withIdentifier(4).withName("Food Overview").withIcon(getResources().getDrawable(R.drawable.calories));

//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        item1,
                        item2,
                        item3,
                        item4


                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        switch (position) {


                            case 1:

                                Intent AccountIntentDrawer = new Intent(getApplicationContext(), UserInformationActivity.class);
                                AccountIntentDrawer.putExtra(Constant.USER_OBJECT, user);
                                startActivity(AccountIntentDrawer);

                                break;


                            case 2://can put intent here etc

                                Intent BodyIntent = new Intent(getApplicationContext(), UpdateBodyDetailsActivity.class);
                                BodyIntent.putExtra(Constant.BODY_OBJECT, bodyDetails);
                                BodyIntent.putExtra(Constant.USER_OBJECT, user);
                                BodyIntent.putExtra(Constant.GOALS_OBJECT, goals);
                                startActivity(BodyIntent);

                                break;

                            case 3:
                                AlertDialog alertDialog = new AlertDialog.Builder(ProfileActivity.this).create();
                                alertDialog.setTitle("Cancel Account?");
                                alertDialog.setIcon(R.drawable.ic_pizza);
                                alertDialog.setMessage("Account will be deleted permanently!");
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancel",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                            }
                                        }
                                );

                                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                new DeleteUser().execute(user);
                                                dialog.dismiss();
                                            }
                                        });
                                alertDialog.show();

                                break;

                            case 4:



                                        Intent OverviewIntent = new Intent(getApplicationContext(), FoodSummaryActivity.class);
                                        OverviewIntent.putExtra(Constant.USER_OBJECT, user);
                                        OverviewIntent.putExtra(Constant.GOALS_OBJECT, goals);
                                        OverviewIntent.putExtra(Constant.FOOD_OBJECT, foodItems);
                                        startActivity(OverviewIntent);

                                }


                        return true;
                    }
                })
                .build();
        //   getUserProfileDetails();
    }
    public class UpdateFoodItems extends AsyncTask<FoodItems, Void, Void> {

        @Override
        protected Void doInBackground(FoodItems... foodItems) {
            updateResult = AppDB.instance().getDao().updateFoodItems(foodItems[0]);
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


    // Step Counter

    @Override
    protected void onResume() {
        super.onResume();
        activityRunning = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Count sensor not available!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        activityRunning = false;
//         if you unregister the last listener, the hardware will stop detecting step events
//        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (activityRunning) {
            textView = (TextView) findViewById(R.id.textRemaining);
            textView.setText(String.valueOf(event.values[0]));
            evsteps = event.values[0];
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    private void createBackSeries() {
        SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("#FFE2E2E2"))
                .setRange(0, mSeriesMax, 0)
                .setInitialVisibility(true)
                .build();

        mBackIndex = mDecoView.addSeries(seriesItem);
    }
    private void createDataSeries1() {
        final SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("#FFFF8800"))
                .setRange(0, mSeriesMax, 0)
                .setInitialVisibility(false)
                .build();

        Log.d("mSeries Data1", (String.valueOf(mSeriesMax)));

        final TextView textPercentage = (TextView) findViewById(R.id.textPercentage);
        seriesItem.addArcSeriesItemListener(new SeriesItem.SeriesItemListener() {
            @Override
            public void onSeriesItemAnimationProgress(float percentComplete, float currentPosition) {
                float percentFilled = ((currentPosition - seriesItem.getMinValue()) / (seriesItem.getMaxValue() - seriesItem.getMinValue()));
                textPercentage.setText(String.format("%.0f%%", percentFilled * 100f));
            }

            @Override
            public void onSeriesItemDisplayProgress(float percentComplete) {

            }
        });


        final TextView textToGo = (TextView) findViewById(R.id.textRemaining);
        seriesItem.addArcSeriesItemListener(new SeriesItem.SeriesItemListener() {
            @Override
            public void onSeriesItemAnimationProgress(float percentComplete, float currentPosition) {
                textToGo.setText(String.format("%d Steps to goal", (int) (seriesItem.getMaxValue() - currentPosition)));

            }

            @Override
            public void onSeriesItemDisplayProgress(float percentComplete) {

            }
        });
        final TextView textActivity1 = (TextView) findViewById(R.id.textActivity1);
        seriesItem.addArcSeriesItemListener(new SeriesItem.SeriesItemListener() {
            @Override
            public void onSeriesItemAnimationProgress(float percentComplete, float currentPosition) {
                textActivity1.setText(String.format("%.0f Steps", currentPosition));
            }

            @Override
            public void onSeriesItemDisplayProgress(float percentComplete) {

            }
        });

        mSeries1Index = mDecoView.addSeries(seriesItem);
    }

    private void createEvents() {
        cont++;
        mDecoView.executeReset();

        if (cont == 1) {
            resetText();
            mDecoView.addEvent(new DecoEvent.Builder(DecoDrawEffect.EffectType.EFFECT_SPIRAL_EXPLODE)
                    .setIndex(mSeries1Index)
                    .setDelay(0)
                    .setDuration(1000)
                    .setDisplayText("")
                    .setListener(new DecoEvent.ExecuteEventListener() {
                        @Override
                        public void onEventStart(DecoEvent decoEvent) {

                        }

                        @Override
                        public void onEventEnd(DecoEvent decoEvent) {
                            createEvents();
                        }
                    })
                    .build());
        }
        mDecoView.addEvent(new DecoEvent.Builder(mSeriesMax)
                .setIndex(mBackIndex)
                .setDuration(3000)
                .setDelay(100)
                .build());

        mDecoView.addEvent(new DecoEvent.Builder(evsteps)
                .setIndex(mSeries1Index)
                .setDelay(3250)
                .build());

        mDecoView.addEvent(new DecoEvent.Builder(DecoDrawEffect.EffectType.EFFECT_SPIRAL_EXPLODE)
                .setIndex(mSeries1Index)
                .setDelay(20000)
                .setDuration(3000)
                .setDisplayText("")
                .setListener(new DecoEvent.ExecuteEventListener() {
                    @Override
                    public void onEventStart(DecoEvent decoEvent) {

                    }

                    @Override
                    public void onEventEnd(DecoEvent decoEvent) {
                        createEvents();
                    }
                })
                .build());

    }

    private void resetText() {
        ((TextView) findViewById(R.id.textPercentage)).setText("");
        ((TextView) findViewById(R.id.textRemaining)).setText("");
    }


/*
    private void getUserProfileDetails() {

        if (user.getGender().equals("Male"))
            image.setImageResource(R.drawable.boy);

        else
            image.setImageResource(R.drawable.girl);


        //firstName.setText(user.getFirstName());
        //lastName.setText(user.getLastName());


        mobile.setText("Phone Number:" + " " + user.getMobileNumber());
        userName.setText("Username:" + " " + user.getUserName());
        name.setText("Name:" + " " + user.getFirstName() + " " + user.getLastName());

        if (bodyDetails.getAge() == null)
            age.setText("");

        else
            age.setText("Age:" + " " + bodyDetails.getAge());

        if (bodyDetails.getBmr() == null)
            bmr.setText("");
        else
            bmr.setText("BMR:" + " " + bodyDetails.getBmr());

        if (bodyDetails.getLifestyle() == null)
            lifestyle.setText("");
        else
            lifestyle.setText("Lifestyle:" + " " + bodyDetails.getLifestyle());

        if (bodyDetails.getWeight() == null)
            weight.setText("");

        else
            weight.setText("weight:" + " " + bodyDetails.getWeight());

        if (bodyDetails.getHeight() == null)
            height.setText("");

        else
            height.setText("height:" + " " + bodyDetails.getHeight());


    }
    */

    /*

    public void btnUpdateProfileClick(View view) {

        Intent intent = new Intent(this, UserInformationActivity.class);
        intent.putExtra(USER_OBJECT, user);
        startActivity(intent);
    }

    public void btnUpdateBodyProfileClick(View view) {

        Intent BodyIntent = new Intent(this, InsertBodyDetailsActivity.class);
        BodyIntent.putExtra(USER_OBJECT, user);
        startActivity(BodyIntent);
    }
*/

    public void btnSetGoalsClick(View view) {



        if (bodyDetails.getWeight() == null
                && bodyDetails.getHeight() == null
                && bodyDetails.getLifestyle() == null
                && bodyDetails.getBmr() == null
                && bodyDetails.getAge() == null) {
            Toast.makeText(getApplicationContext(),
                    "Enter Body Details!", Toast.LENGTH_LONG).show();
        } else {
            Intent GoalsIntent = new Intent(this, GoalsActivity.class);
            // GoalsIntent.putExtra(USER_OBJECT, user);
            startActivity(GoalsIntent);
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        return false;
    }

    private class DeleteUser extends AsyncTask<User, Void, Void> {

        @Override
        protected Void doInBackground(User... users) {
            deleteResult = MainActivity.userDao.deleteUsers(users[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (deleteResult == 1)
                Toast.makeText(getApplicationContext(),
                        "User Record has been deleted",
                        Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),
                        "User Record has not been deleted",
                        Toast.LENGTH_LONG).show();
        }

    }



}
