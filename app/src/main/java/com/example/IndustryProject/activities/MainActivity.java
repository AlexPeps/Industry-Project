package com.example.IndustryProject.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;

import com.example.IndustryProject.FoodSummaryActivity;
import com.example.IndustryProject.R;
import com.example.IndustryProject.SearchActivity;
import com.example.IndustryProject.UpdateBodyDetailsActivity;
import com.example.IndustryProject.UserInformationActivity;
import com.example.IndustryProject.db.entities.BodyDetails;
import com.example.IndustryProject.db.entities.FoodItems;
import com.example.IndustryProject.db.entities.Goals;
import com.example.IndustryProject.db.entities.User;
import com.example.IndustryProject.utils.Constant;
import com.example.IndustryProject.utils.SPApp;
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


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SensorEventListener {

    public static float evsteps;
    public static int cont = 0;
    public static float mSeriesMax = 0f;
    boolean activityRunning;
    Goals goals;
    User user;
    FoodItems foodItems;
    BodyDetails bodyDetails;
    private DecoView mDecoView;
    private TextView textView;
    private int mBackIndex;
    private int mSeries1Index;

    private SensorManager mSensorManager;
    private static int mStepSensorType = -1;

    private boolean mHasRecord;
    private int mCurrentStep;
    private int mHasStepCount = 0;
    private int mPreviousStepCount = 0;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);

        user = SPApp.getUser(this);
        goals = SPApp.getGoals(this);
        mSeriesMax = Float.parseFloat(goals.getStepGoal());

        mDecoView = findViewById(R.id.dynamicArcView);
        createBackSeries();
        createDataSeries1();
        createEvents();

        ImageView btnNext = findViewById(R.id.datanext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, SearchActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(MainActivity.this, v, "testAnimation");
                    MainActivity.this.startActivity(intent1, options.toBundle());
                } else {
                    startActivity(intent1);
                }
            }
        });

        toolbar = findViewById(R.id.my_toolbar);
        setToolbar(toolbar);

        createDrawerBuilder();
    }

    private void setToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_24px);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_24px);
    }

    @Override
    protected void onResume() {
        super.onResume();
        activityRunning = true;
        if (mSensorManager != null) {
            mSensorManager = null;
        }
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        int VERSION_CODES = Build.VERSION.SDK_INT;
        if (VERSION_CODES >= 19) {
            addCountStepListener();
        } else {
            addBasePedometerListener();
        }
    }

    private void addBasePedometerListener() {
        // TODO:
    }

    private void addCountStepListener() {
        Sensor countSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        Sensor detectorSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        if (countSensor != null) {
            mStepSensorType = Sensor.TYPE_STEP_COUNTER;
            mSensorManager
                    .registerListener(this, countSensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else if (detectorSensor != null) {
            mStepSensorType = Sensor.TYPE_STEP_DETECTOR;
            mSensorManager.registerListener(this, detectorSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            addBasePedometerListener();
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
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (mStepSensorType) {
            case Sensor.TYPE_STEP_COUNTER:
                int tempStep = (int) sensorEvent.values[0];

                if (!mHasRecord) {
                    mHasRecord = true;
                    mHasStepCount = tempStep;
                } else {
                    int thisStepCount = tempStep - mHasStepCount;
                    int thisStep = thisStepCount - mPreviousStepCount;
                    mCurrentStep += thisStep;
                    mPreviousStepCount = thisStepCount;
                }
                break;
            case Sensor.TYPE_STEP_DETECTOR:
                if (sensorEvent.values[0] == 1.0) {
                    mCurrentStep++;
                }
                break;
        }

        TextView textActivity1 = (TextView) findViewById(R.id.textActivity1);
        textActivity1.setText(String.format("%d Steps", mCurrentStep));

        TextView textPercentage = (TextView) findViewById(R.id.textPercentage);
        TextView textToGo = (TextView) findViewById(R.id.textRemaining);

        if (mCurrentStep < mSeriesMax) {
            float percentFilled = (mCurrentStep / mSeriesMax);
            textPercentage.setText(String.format("%.0f%%", percentFilled * 100f));
            textToGo.setText(String.format("%d Steps to goal", (int) (mSeriesMax - mCurrentStep)));

            mDecoView.addEvent(new DecoEvent.Builder(mCurrentStep)
                    .setIndex(mSeries1Index)
                    .setDuration(3000)
                    .setDelay(1)
                    .build());
        } else {
            textPercentage.setText("100%");
            textToGo.setText("Done!");
            mDecoView.addEvent(new DecoEvent.Builder(DecoDrawEffect.EffectType.EFFECT_SPIRAL_EXPLODE)
                    .setIndex(mSeries1Index)
                    .setDelay(1)
                    .setDuration(3000)
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
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    private void createBackSeries() {
        SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("#FFE2E2E2"))
                .setRange(0, mSeriesMax, mSeriesMax)
                .setInitialVisibility(true)
                .build();
        mBackIndex = mDecoView.addSeries(seriesItem);
    }

    private void createDataSeries1() {
        SeriesItem seriesItem = new SeriesItem.Builder(Color.parseColor("#FFFF8800"))
                .setRange(0, mSeriesMax, 0)
                .setInitialVisibility(false)
                .build();
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
    }

    private void resetText() {
        ((TextView) findViewById(R.id.textPercentage)).setText("");
        ((TextView) findViewById(R.id.textRemaining)).setText("");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    private void createDrawerBuilder() {
        new DrawerBuilder().withActivity(this).build();
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .addProfiles(new ProfileDrawerItem().withName(user.getFirstName() + " " + user.getLastName()).withEmail(user.getMobileNumber()).withIcon(getDrawable(R.drawable.ic_pizza)))
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Update Account Details").withIcon(getResources().getDrawable(R.drawable.ic_pizza));
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("Update Body Details").withIcon(getResources().getDrawable(R.drawable.ic_account_box_24px));
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("Delete Account").withIcon(getResources().getDrawable(R.drawable.ic_delete_24px));
        SecondaryDrawerItem item4 = new SecondaryDrawerItem().withIdentifier(4).withName("Food Overview").withIcon(getResources().getDrawable(R.drawable.calories));

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
                                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
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
                                                dialog.dismiss();
                                            }
                                        });
                                alertDialog.show();
                                break;
                            case 4:
                                Intent intent = new Intent(getApplicationContext(), FoodSummaryActivity.class);
                                FoodSummaryActivity.calRef = 0;
                                intent.putExtra(Constant.EVSTEP, mCurrentStep);
                                intent.putExtra(Constant.FOOD_OBJECT, foodItems);
                                intent.putExtra(Constant.GOALS_OBJECT, goals);
                                startActivity(intent);
                        }
                        return true;
                    }
                })
                .build();
    }
}
