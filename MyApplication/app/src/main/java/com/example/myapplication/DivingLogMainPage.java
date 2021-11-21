package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.InputMismatchException;

public class DivingLogMainPage extends AppCompatActivity {

    Button divelog,logbook,backtoProfile,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diving_log_main_page);



        divelog = (Button)findViewById(R.id.new_divelog);
        logbook = (Button)findViewById(R.id.log_book);
        backtoProfile = (Button)findViewById(R.id.back_to_profile);
        logout = (Button)findViewById(R.id.log_out);


        divelog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DivingLocation.class);
                startActivity(intent);

            }
        });

        logbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DivingLogbook.class);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(DivingLogMainPage.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });

        backtoProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UserHomePage.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                Toast.makeText(DivingLogMainPage.this, "Logout Successful", Toast.LENGTH_SHORT).show();
            }
        });

    }
}