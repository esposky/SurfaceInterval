package com.example.demologinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.otherjavafiles.LocationDetails;

import java.util.InputMismatchException;

public class DivingLocation extends AppCompatActivity {

    private static LocationDetails locationDetails;

    TextView output;
    EditText location,siteName,month,day,year,hour,minutes;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diving_location);
        // Grabbing userID from previous page

        output = (TextView)findViewById(R.id.output4);

        location = (EditText)findViewById(R.id.dive_location);
        siteName = (EditText)findViewById(R.id.site_name);
        month = (EditText)findViewById(R.id.date_month);
        day = (EditText)findViewById(R.id.date_day);
        year = (EditText)findViewById(R.id.date_year);
        hour = (EditText)findViewById(R.id.hours);
        minutes =(EditText)findViewById(R.id.minutes);


        findViewById(R.id.complete_locationDetails).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*try {

                    String input_location = location.getText().toString();
                    String input_siteName = siteName.getText().toString();

                    String input_month = month.getText().toString();
                    int m = Integer.parseInt(input_month);

                    String input_day = day.getText().toString();
                    int d = Integer.parseInt(input_day);

                    String input_year = year.getText().toString();
                    int y = Integer.parseInt(input_year);

                    String input_hour = hour.getText().toString();
                    int h = Integer.parseInt(input_hour);

                    String input_minutes = minutes.getText().toString();
                    int mm = Integer.parseInt(input_minutes);

                    if (input_location.isEmpty() || input_siteName.isEmpty() ||
                            input_month.isEmpty() || input_day.isEmpty() || input_year.isEmpty() ||
                            input_hour.isEmpty() || input_minutes.isEmpty()) {
                        throw new InputMismatchException("Please Enter the following details and then press complete");
                    }
                    locationDetails = new LocationDetails(input_location,y, m, d,h,mm,input_siteName);
                    output.setText(locationDetails.toString());
                }catch (InputMismatchException e) {

                    Toast.makeText(DivingLocation.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }*/

            }
        });

        next = (Button)findViewById(R.id.next1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String input_location = location.getText().toString();
                    String input_siteName = siteName.getText().toString();

                    String input_month = month.getText().toString();
                    int m = Integer.parseInt(input_month);

                    String input_day = day.getText().toString();
                    int d = Integer.parseInt(input_day);

                    String input_year = year.getText().toString();
                    int y = Integer.parseInt(input_year);

                    String input_hour = hour.getText().toString();
                    int h = Integer.parseInt(input_hour);

                    String input_minutes = minutes.getText().toString();
                    int mm = Integer.parseInt(input_minutes);

                    if (input_location.isEmpty() || input_siteName.isEmpty() ||
                            input_month.isEmpty() || input_day.isEmpty() || input_year.isEmpty() ||
                            input_hour.isEmpty() || input_minutes.isEmpty()) {
                        throw new InputMismatchException("Please Enter the following details and then press complete");
                    }
                    locationDetails = new LocationDetails(input_location, y, m, d, h, mm, input_siteName);
                    output.setText(locationDetails.toString());

                    Intent intent = new Intent(getApplicationContext(), DivingInformation1.class);
                    startActivity(intent);
                }catch (InputMismatchException e) {

                Toast.makeText(DivingLocation.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
            }
        });
    }
    public static LocationDetails getData() {
        return locationDetails;
    }
}