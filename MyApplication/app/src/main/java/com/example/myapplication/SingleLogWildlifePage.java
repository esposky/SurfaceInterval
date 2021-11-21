package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.otherjavafiles.DatabaseHelper;
import com.example.otherjavafiles.SingleLogTest;
import com.example.otherjavafiles.WildLife;
import com.example.otherjavafiles.WildLifeList;

import java.util.ArrayList;
import java.util.List;

public class SingleLogWildlifePage extends AppCompatActivity {

    private static WildLife wildLife;
    private static WildLifeList wildLifeList;

    DatabaseHelper databaseHelper;
    ArrayAdapter arrayAdapter;
    ListView lvWildlife;
    List<WildLife> list;
    SingleLogTest log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_log_wildlife_page);

        Intent intent = getIntent();
        log = (SingleLogTest) intent.getSerializableExtra("singleLogObject");

        lvWildlife = findViewById(R.id.lvSingleWildlife);
        databaseHelper = new DatabaseHelper(SingleLogWildlifePage.this);
        list = new ArrayList<WildLife>();
        showAllWildlife(databaseHelper);


    }

    // Adding now

    private void showAllWildlife(DatabaseHelper databaseHelper2) {
        arrayAdapter = new ArrayAdapter<>(SingleLogWildlifePage.this, android.R.layout.simple_expandable_list_item_1, databaseHelper2.getSingleWildlife(log));
        lvWildlife.setAdapter(arrayAdapter);
    }
}