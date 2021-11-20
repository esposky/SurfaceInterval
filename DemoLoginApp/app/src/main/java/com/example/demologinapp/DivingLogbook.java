package com.example.demologinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.otherjavafiles.DatabaseHelper;
import com.example.otherjavafiles.SingleLogTest;

import java.util.ArrayList;

public class DivingLogbook extends AppCompatActivity {

    private static SingleLogTest singleLogTest;
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

        // On click of log get log info and send it to the new page to view
        lvDiveLogs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                singleLogTest = (SingleLogTest) parent.getItemAtPosition(position);
                Intent intent = new Intent(DivingLogbook.this, SingleLog.class);
                intent.putExtra("singleLogObject", singleLogTest);
                startActivity(intent);
            }
        });
    }

    private void showAllDiveLogs(DatabaseHelper databaseHelper2) {
        customArrayAdapter = new ArrayAdapter<>(DivingLogbook.this, android.R.layout.simple_expandable_list_item_1, databaseHelper2.getLogsTest());
        lvDiveLogs.setAdapter(customArrayAdapter);
    }
}