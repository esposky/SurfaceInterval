package com.example.demologinapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.otherjavafiles.DatabaseHelper;
import com.example.otherjavafiles.SingleLog;

public class OtherDivingDetails extends AppCompatActivity {

    private static final String MY_PREFS = "MyPrefsFile";

    Button wildlife, equipment,divebuddy, complete, backtoprofile, mainPage;
    TextView textView;
    DatabaseHelper databaseHelper;

    SharedPreferences myPrefs;
    String wildlifeID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_diving_details);
        myPrefs = this.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        // Grabbing userID from previous page
        Bundle bundle = getIntent().getExtras();
        String userID = bundle.getString("ID");
        wildlifeID = myPrefs.getString("wildlifeID", "Nothing yet");


        textView = (TextView)findViewById(R.id.textView8);
        wildlife = (Button)findViewById(R.id.wild_life);
        equipment = (Button)findViewById(R.id.equipment);
        divebuddy = (Button)findViewById(R.id.dive);
        complete = (Button)findViewById(R.id.diveDetails_complete);
        backtoprofile = (Button)findViewById(R.id.back_to_profile2);
        textView.setText(wildlifeID);

        //Buttons that leads to other class
        //Wildlife button leads to wildlife.class
        wildlife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),WildLifeDetails.class);
                intent.putExtra("ID", userID);
                startActivity(intent);
                //getWildLifeIDLauncher.launch(intent);
            //startActivityForResult(intent, MY_REQUEST_CODE);
                //textView.setText(wildlifeID);
            }
        });
        //equipment button will lead to the equipment.class
        equipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),EquipmentInformation.class);
                intent.putExtra("ID", userID);
                startActivity(intent);

            }
        });
        //divebuddy button will lead to the divebuddy.class
        divebuddy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DivingBuddy.class);
                intent.putExtra("ID", userID);
                startActivity(intent);
            }
        });

        //String finalWildlifeID = wildlifeID;
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Once button is clicked the completed information is stored in the database

                SingleLog singleLog = new SingleLog(DivingLocation.getData(),DivingInformation1.getData(),DivingBuddy.getData(),EquipmentInformation.getData(),WildLifeDetails.getData());
                try {
                    databaseHelper = new DatabaseHelper(OtherDivingDetails.this);
                    Boolean insertLog = databaseHelper.addNewLog(singleLog, userID);
                    if (insertLog) {
                        Intent intent = new Intent(getApplicationContext(), CompletedNewDiveLog.class);
                        intent.putExtra("ID", userID);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(OtherDivingDetails.this, "Can't insert log", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(OtherDivingDetails.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        backtoprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UserHomePage.class);
                intent.putExtra("ID", userID);
                startActivity(intent);
            }
        });


    }
}





































