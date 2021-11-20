package com.example.demologinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.otherjavafiles.SingleLogTest;

public class SingleLog extends AppCompatActivity {

    // Text views for Location Details
    TextView tvDLResult, tvSNResult, tvDateResult, tvTimeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_log);

        // Grab singleLog object from previous page
        Intent intent = getIntent();
        SingleLogTest log = (SingleLogTest) intent.getSerializableExtra("singleLogObject");

        // Set variables for text views
        tvDLResult = findViewById(R.id.tvDLResult);
        tvSNResult = findViewById(R.id.tvSNResult);
        tvDateResult = findViewById(R.id.tvDateResult);
        tvTimeResult = findViewById(R.id.tvTimeResult);

        // Display variable from log
        tvDLResult.setText(log.getLocation().getLocation());
        tvSNResult.setText(log.getLocation().getSiteName());
        tvDateResult.setText(log.getLocation().getDate());
        tvTimeResult.setText(log.getLocation().getTime());

    }
}