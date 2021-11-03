package com.example.demologinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demologinapp.MainActivity;
import com.example.demologinapp.MySQLiteDatabase;
import com.example.demologinapp.R;
import com.example.demologinapp.RegistrationCompletePage;
import com.example.demologinapp.UserHomePage;
import com.example.otherjavafiles.DatabaseHelper;
import com.example.otherjavafiles.UserInfo;

public class NewUserRegistration extends AppCompatActivity {

    Button return_to_login, complete_registration;
    EditText username, password, confirm_password, user_email;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_registration);

        username = (EditText)findViewById(R.id.user_name);
        user_email = (EditText)findViewById(R.id.user_email);
        password = (EditText)findViewById(R.id.user_password);
        confirm_password = (EditText)findViewById(R.id.confirm_user_password);
        return_to_login = (Button)findViewById(R.id.return_login);
        complete_registration = (Button)findViewById(R.id.registration_complete);

        databaseHelper = new DatabaseHelper(NewUserRegistration.this);

        //For registration!
        complete_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String email = user_email.getText().toString();
                String pass = password.getText().toString();
                String confirm = confirm_password.getText().toString();

                UserInfo userInfo;
                try {
                    // If empty fields are empty let the user know
                    if (user.equals(" ") || pass.equals("") || confirm.equals(" "))
                        Toast.makeText(NewUserRegistration.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                    else {
                        // Check to see to that password and confirmation password are the same
                        if (pass.equals(confirm)) {

                            // Checks to see if email is already in the database
                            Boolean check_email = databaseHelper.check_email(email);
                            // If not then we add the user
                            if (check_email == false) {
                                userInfo = new UserInfo(-1, user, email, pass);
                                Boolean data_insert = databaseHelper.addNewUser(userInfo);

                                // Adds users and sends them to the complete registration page
                                if (data_insert) {
                                    Toast.makeText(NewUserRegistration.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), RegistrationCompletePage.class);
                                    startActivity(intent);
                                }
                                // Else lets the user know that registration failed
                                else {
                                    Toast.makeText(NewUserRegistration.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                }
                            // Lets user know that email already exists
                            } else {
                                Toast.makeText(NewUserRegistration.this, "User already exists! Please use new Email", Toast.LENGTH_SHORT).show();
                            }
                        }
                        // Lets user know that password does not match
                        else {
                            Toast.makeText(NewUserRegistration.this, "User Password does not match!", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {

                }
            }
        });

        //This block of code is what makes the return to login button work and when pushed goes back to login page.
        return_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when user clicks on join now the user registration page should pop up
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                Toast.makeText(NewUserRegistration.this,"Welcome back!" ,Toast.LENGTH_SHORT).show();
            }
        });
    }

}//Do not touch!
