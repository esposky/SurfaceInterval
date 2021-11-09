package com.example.demologinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.otherjavafiles.DatabaseHelper;

public class EquipmentMenu extends AppCompatActivity {

    // Set preferences
    private static  final String MY_PREFS = "MyPrefsFile";

    ListView lvEquipment;
    ArrayAdapter customArrayAdapter;
    DatabaseHelper databaseHelper;
    SharedPreferences sharedPreferences;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_menu);

        // Set list and database
        lvEquipment = findViewById(R.id.lvEquipment);
        sharedPreferences = this.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        userID = sharedPreferences.getString("userID", "Nothing");
        databaseHelper = new DatabaseHelper(EquipmentMenu.this);

        //List all Equipment
        showAllEquipment(databaseHelper);
    }

    private void showAllEquipment(DatabaseHelper databaseHelper2) {
        customArrayAdapter = new ArrayAdapter<>(EquipmentMenu.this, android.R.layout.simple_expandable_list_item_1, databaseHelper2.getEquipment(userID));
        lvEquipment.setAdapter(customArrayAdapter);
    }
}