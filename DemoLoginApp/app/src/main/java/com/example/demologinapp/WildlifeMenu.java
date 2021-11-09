package com.example.demologinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.otherjavafiles.DatabaseHelper;

public class WildlifeMenu extends AppCompatActivity {
    // Set preferences
    private static  final String MY_PREFS = "MyPrefsFile";

    ListView lvWildlife;
    ArrayAdapter customArrayAdapter;
    DatabaseHelper databaseHelper;
    SharedPreferences sharedPreferences;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wildlife_menu);

        // Set list and database
        lvWildlife = findViewById(R.id.lvWildlife);
        sharedPreferences = this.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        userID = sharedPreferences.getString("userID", "Nothing");
        databaseHelper = new DatabaseHelper(WildlifeMenu.this);

        //List all wildlife
        showAllWildlife(databaseHelper);
    }

    private void showAllWildlife(DatabaseHelper databaseHelper2) {
        customArrayAdapter = new ArrayAdapter<>(WildlifeMenu.this, android.R.layout.simple_expandable_list_item_1, databaseHelper2.getWildlife(userID));
        lvWildlife.setAdapter(customArrayAdapter);
    }
}