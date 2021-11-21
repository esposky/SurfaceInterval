package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.otherjavafiles.SingleLogTest;

public class SingleLogPage extends AppCompatActivity {

    // Text views for Location Details
    TextView tvDLResult, tvSNResult, tvDateResult, tvTimeResult;

    // Text Views for Diving Details
    TextView tvDurationResult, tvMaxDepthResult, tvAvgDepthResult, tvTempResult, tvVisibilityResult;
    TextView tvStartPressResult, tvEndPressResult, tvAirTypeResult, tvDiveConditions, tvDiveActivites;

    // Buttons to send to wildlife and equipment pages
    Button btnViewWildlife, btnViewEquipment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_log);

        // Grab singleLog object from previous page
        Intent intent = getIntent();
        SingleLogTest log = (SingleLogTest) intent.getSerializableExtra("singleLogObject");

        // Set variables for text views (Location Details)
        tvDLResult = findViewById(R.id.tvDLResult);
        tvSNResult = findViewById(R.id.tvSNResult);
        tvDateResult = findViewById(R.id.tvDateResult);
        tvTimeResult = findViewById(R.id.tvTimeResult);

        // Set variables for text views (Dive Details)
        tvDurationResult = findViewById(R.id.tvDurationResult);
        tvMaxDepthResult = findViewById(R.id.tvMaxDepthResult);
        tvAvgDepthResult = findViewById(R.id.tvAvgDepthResult);
        tvTempResult = findViewById(R.id.tvTempResult);
        tvVisibilityResult = findViewById(R.id.tvVisibilityResult);
        tvStartPressResult = findViewById(R.id.tvPressStartResult);
        tvEndPressResult = findViewById(R.id.tvPressEndResult);
        tvAirTypeResult = findViewById(R.id.tvAirTypeResult);
        tvDiveConditions = findViewById(R.id.tvDiveCondResult);
        tvDiveActivites = findViewById(R.id.tvDiveActResult);

        // Set Variables for buttons (Wildlife and Equipment)
        btnViewWildlife = findViewById(R.id.btnViewWildlife);
        btnViewEquipment = findViewById(R.id.btnViewWildlife);

        // Display variable from log (Location details)
        tvDLResult.setText(log.getLocation().getLocation());
        tvSNResult.setText(log.getLocation().getSiteName());
        tvDateResult.setText(log.getLocation().getDate());
        tvTimeResult.setText(log.getLocation().getTime());

        // Display variable from log (Dive details)
        tvDurationResult.setText(log.getDive().getDuration()+"");
        tvMaxDepthResult.setText(log.getDive().getMaxDepth()+"");
        tvAvgDepthResult.setText(log.getDive().getAvgDepth()+"");
        tvTempResult.setText(log.getDive().getTemp()+"");
        tvVisibilityResult.setText(log.getDive().getVisibility()+"");
        tvStartPressResult.setText(log.getDive().getPressureStart()+"");
        tvEndPressResult.setText(log.getDive().getPressureEnd()+"");
        tvAirTypeResult.setText(log.getDive().getAirType()+"");
        tvDiveConditions.setText(log.getDive().getDiveConditionsNA()+"");
        tvDiveActivites.setText(log.getDive().getDiveActivitiesNA()+"");

        btnViewWildlife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wildlifeIntent = new Intent(getApplicationContext(), SingleLogWildlifePage.class);
                intent.putExtra("singleLogObject", log);
                startActivity(wildlifeIntent);
            }
        });

        btnViewEquipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent equipmentIntent = new Intent(getApplicationContext(), SingleLogEquipmentPage.class);
                startActivity(equipmentIntent);
            }
        });

    }
}