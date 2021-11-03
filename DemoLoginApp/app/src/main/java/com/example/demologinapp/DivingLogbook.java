package com.example.demologinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.otherjavafiles.DatabaseHelper;
import com.example.otherjavafiles.SingleLog;

import java.util.ArrayList;

public class DivingLogbook extends AppCompatActivity {

    ListView lvDiveLogs;
    ArrayAdapter customArrayAdapter;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diving_logbook);

        //Set interactive buttons and lists
        lvDiveLogs = findViewById(R.id.lv_divelogs);

        databaseHelper = new DatabaseHelper(DivingLogbook.this);

        // Populate and show logs
        try {
            showAllDiveLogs(databaseHelper);
        } catch (Exception e) {
            Toast.makeText(DivingLogbook.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void showAllDiveLogs(DatabaseHelper databaseHelper2) {
        customArrayAdapter = new ArrayAdapter<>(DivingLogbook.this, android.R.layout.simple_expandable_list_item_1, databaseHelper2.getLogs());
        lvDiveLogs.setAdapter(customArrayAdapter);
    }
}