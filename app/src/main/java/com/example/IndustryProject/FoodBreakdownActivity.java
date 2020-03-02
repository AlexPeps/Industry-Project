package com.example.IndustryProject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.EditText;
import android.widget.ListView;

import com.example.IndustryProject.db.model.BodyDetails;
import com.example.IndustryProject.db.model.FoodItems;
import com.example.IndustryProject.db.model.User;
import com.example.IndustryProject.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class FoodBreakdownActivity extends AppCompatActivity {

    private FoodBreakdownListAdapter FoodBreakdownListAdapter;
    private ListView listView;
    EditText editTextSearch;
    ArrayList<String> arrayList ;
    private ArrayList foodList = new ArrayList();
    FoodItems foodItems;
    User user;
    List<String[]> mFoodList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_break);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        user = (User) getIntent().getSerializableExtra(Constant.USER_OBJECT);
        BodyDetails body = (BodyDetails) getIntent().getSerializableExtra(Constant.BODY_OBJECT);
        foodItems = (FoodItems) getIntent().getSerializableExtra(Constant.FOOD_OBJECT);
        editTextSearch = findViewById(R.id.txt_search);
        listView = (ListView) findViewById(R.id.listFoodBreak);
        FoodBreakdownListAdapter = new FoodBreakdownListAdapter(getApplicationContext(), R.layout.item_layout);

        Parcelable state = listView.onSaveInstanceState();
        listView.setAdapter(FoodBreakdownListAdapter);
        listView.onRestoreInstanceState(state);
    }
}
