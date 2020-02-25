package com.example.IndustryProject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.widget.Toolbar;

import com.example.IndustryProject.db.model.FoodItems;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends Activity {


    private ListViewAdapter ListViewAdapter;
    private ListView listView;
    EditText editTextSearch;
    ArrayList<String> arrayList ;
    private ArrayList foodList = new ArrayList();
    public static final String FOOD_OBJECT= "FOOD_OBJECT";
    FoodItems foodItems;

    List<String[]> mFoodList;





    private static final String TAG = "SearchActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //csv read using the below example with a few changes

        //https://javapapers.com/android/android-read-csv-file/




        Log.d(TAG, "onCreate: Started");

        editTextSearch = findViewById(R.id.txt_search);

        listView = (ListView) findViewById(R.id.listFood);
        ListViewAdapter = new ListViewAdapter(getApplicationContext(), R.layout.item_layout);





        Parcelable state = listView.onSaveInstanceState();
        listView.setAdapter(ListViewAdapter);
        listView.onRestoreInstanceState(state);



        //uses CSVFile class in another file

        InputStream inputStream = getResources().openRawResource(R.raw.data);
        CSVFile csvFile = new CSVFile(inputStream);

        //had to change list to string otherwise wouldn't work


         mFoodList = csvFile.read();
        //send the array of strings to the adapter to populate the list
        for (String[] foodData : mFoodList) {
            ListViewAdapter.add(foodData);
        }

        //need to convert List<String[]> to arrayList
        arrayList = new ArrayList<>();
        for (int i=0; i<mFoodList.size(); i++){
            arrayList.add(mFoodList.get(i)[2]);
        }





        //adding a TextChangedListener
        //to call a method whenever there is some change on the EditText
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty())
                    filter(editable.toString());
            }

            });

        //set toolbar
        //back button to send data with intent

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class );
                intent.putExtra(FOOD_OBJECT, foodItems);
                startActivity(intent);

            }
        });



    }

            //filter from https://www.simplifiedcoding.net/search-functionality-recyclerview/

    private void filter(String text) {
        //new array list that will hold the filtered data
        ArrayList<String[]> filteredList = new ArrayList<>();


        //looping through existing elements
        int pos = 0;
        for (String s : arrayList) {
            pos ++;
            //if the existing elements contains the search input
            if (s.toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filteredList.add(mFoodList.get(pos));
            }
        }

        //calling a method of the adapter class and passing the filtered list
        ListViewAdapter.filterList(filteredList);
    }



    }











