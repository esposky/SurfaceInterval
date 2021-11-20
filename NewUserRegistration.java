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

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                    //regex for email validation
                    String emailRegex = "^[\\w!#$%&'*+/=?'{|}~^-]+(?:\\.[\\w!#$%&'*+/=?'{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
                    Pattern emailPattern = Pattern.compile(emailRegex);
                    Matcher emailMatcher = emailPattern.matcher(email);

                    //regex for password validation
                    String pwRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
                    Pattern pwPattern = Pattern.compile(pwRegex);
                    Matcher pwMatcher = pwPattern.matcher((pass));

                    //input validation for email address and password fields
                    if(user.equals(""))
                        throw new InputMismatchException("Please provide valid user name");
                    if(!emailMatcher.matches())
                        throw new InputMismatchException("Please provide valid email address");
                    if(!pwMatcher.matches())
                        throw new InputMismatchException("Please provide a more secure password");
                    if (!confirm.equals(pass))
                        throw new InputMismatchException("Please check your password to ensure it is entered accurately");

                    // Checks to see if email is already in the database
                    // If not then we add the user
                    if(databaseHelper.check_email(email))
                        throw new InputMismatchException("Email address already registered, please login with your existing credentials");
                    userInfo = new UserInfo(-1, user, email, pass);
                    Boolean data_insert = databaseHelper.addNewUser(userInfo);
                    // Adds users and sends them to the complete registration page
                    if (data_insert) {
                        Toast.makeText(NewUserRegistration.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), RegistrationCompletePage.class);
                        startActivity(intent);
                    }
                    else
                        throw new RuntimeException("Registration failed, please try again");


                } catch (Exception e){
                    Toast.makeText(NewUserRegistration.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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
