package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddNewDiveBuddyOrSelectFromPrevious extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_dive_buddy_or_select_from_previous);


        findViewById(R.id.addNew_divebuddy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DivingBuddy.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.selectFrom_previous3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PreviousDiveBuddies.class);
                startActivity(intent);

            }
        });


        findViewById(R.id.back_to_otherDetails6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),OtherDivingDetails.class);
                startActivity(intent);
            }
        });

    }
}