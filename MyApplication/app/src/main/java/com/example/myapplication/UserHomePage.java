package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.InputMismatchException;

public class UserHomePage extends AppCompatActivity {

    Button to_DiveLog,back_toLogin, btnWildlife, btnEquipment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);

        // Get values from previous page
        //Bundle bundle = getIntent().getExtras();
        //String userID = bundle.getString("ID");

        to_DiveLog = (Button) findViewById(R.id.enter_DiveLog);
        back_toLogin = (Button) findViewById(R.id.back_to_signIn);
        btnWildlife = findViewById(R.id.btn_Wildlife);
        btnEquipment = findViewById(R.id.btn_Equipment);


        // On click listener to send user to their divelog page
        to_DiveLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DivingLogMainPage.class);
                startActivity(intent);
            }
        });
        // On click listener to log user out
        back_toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignOutActivity.class);
                startActivity(intent);
            }
        });

        // On click listener to send user to their wildlife page
        btnWildlife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),WildlifeMenu.class);
                startActivity(intent);
            }
        });

        // On click listener to send user to their equipment page
        btnEquipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EquipmentMenu.class);
                startActivity(intent);
            }
        });


    }
}