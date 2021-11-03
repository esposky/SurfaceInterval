package com.example.demologinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserHomePage extends AppCompatActivity {

    Button to_DiveLog,back_toLogin;
    TextView loginID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);

        // Get values from previous page
        Bundle bundle = getIntent().getExtras();
        String userID = bundle.getString("ID");

        to_DiveLog = (Button) findViewById(R.id.enter_DiveLog);
        back_toLogin = (Button) findViewById(R.id.back_to_signIn);
        loginID = findViewById(R.id.textView3);

        loginID.setText(userID);

        to_DiveLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DivingLogMainPage.class);
                intent.putExtra("ID", userID);
                startActivity(intent);
            }
        });

        back_toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignOutActivity.class);
                startActivity(intent);
            }
        });
    }
}