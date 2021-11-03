package com.example.demologinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.otherjavafiles.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
    private static final String MY_PREFS = "MyPrefsFile";
    EditText username, password;
    TextView join_now;
    Button user_Login;
    DatabaseHelper databaseHelper;

    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.userPassword);
        join_now = (TextView)findViewById(R.id.user_joinNow);
        user_Login = (Button)findViewById(R.id.login_button);

        databaseHelper = new DatabaseHelper(MainActivity.this);

        //For users who are signing in! This would actually go on the UserLoginScreen.class page
        user_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String user = username.getText().toString();
                String pass = password.getText().toString();
                try {
                    // Checks if username and password fields are empty
                    if (user.equals("") || pass.equals(""))
                        Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                    // If not empty checks to see if username and password are in the database to login
                    else {
                        boolean exists = databaseHelper.checkExists(user, pass);
                        // If it exists login and store the users ID
                        if (exists) {

                            Toast.makeText(MainActivity.this, "Sign in successful!", Toast.LENGTH_SHORT).show();
                            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();
                            editor.putString("userID", databaseHelper.getLastLogId(user, pass));
                            editor.apply();
                            Intent intent = new Intent(getApplicationContext(), UserHomePage.class);
                            intent.putExtra("ID", databaseHelper.getLastLogId(user, pass));
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "User Credentials invalid!", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error When changing", Toast.LENGTH_SHORT).show();
                }
            }
        });

        join_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NewUserRegistration.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();

            }
        });


    }
}//Do not touch!