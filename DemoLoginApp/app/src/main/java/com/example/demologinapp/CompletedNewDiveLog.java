package com.example.demologinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.otherjavafiles.LocationDetails;
import com.example.otherjavafiles.SingleLog;

public class CompletedNewDiveLog extends AppCompatActivity {

    TextView output, output1,output2, output3;
    Button mainPageReturn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_new_dive_log);
        SingleLog singleLog = new SingleLog(DivingLocation.getData(),DivingInformation1.getData(),DivingBuddy.getData(),EquipmentInformation.getData(),WildLifeDetails.getData());
        // Grabbing userID from previous page
        Bundle bundle = getIntent().getExtras();
        String userID = bundle.getString("ID");

//        output = (TextView)findViewById(R.id.textView4);
//        output.setText(DivingBuddy.getData().toString());
//
//        output1 = (TextView)findViewById(R.id.textView5);
//        output1.setText(DivingInformation1.getData().toString());
//
//        output2 = (TextView)findViewById(R.id.textView6);
//        output2.setText(DivingLocation.getData().toString());
//
//        output3 = (TextView)findViewById(R.id.textView7);
//        output3.setText(WildLifeDetails.getData().toString());


        mainPageReturn = (Button)findViewById(R.id.back_to_profile3);

        mainPageReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UserHomePage.class);
                intent.putExtra("ID", userID);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(CompletedNewDiveLog.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
