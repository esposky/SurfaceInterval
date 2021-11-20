package com.example.demologinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.otherjavafiles.DiveDetails;

import java.util.InputMismatchException;

public class DivingInformation1 extends AppCompatActivity {


    private static DiveDetails diveDetails;
    TextView output;
    Button continueDiveDetails, back;
    EditText duration, maxDepth, avgDepth, temp, visibility, pressureStart, pressureEnd, airType;
    String[] activ;
    String[] cond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diving_information1);

        // Grabbing userID from previous page


        duration = (EditText) findViewById(R.id.enter_duration);
        maxDepth = (EditText) findViewById(R.id.enter_max);
        avgDepth = (EditText) findViewById(R.id.enter_avgDepth);
        temp = (EditText) findViewById(R.id.enter_Temp);
        visibility = (EditText) findViewById(R.id.enter_visibility);
        pressureStart = (EditText) findViewById(R.id.enter_pressureStart);
        pressureEnd = (EditText) findViewById(R.id.enter_pressureEnd);
        airType = (EditText) findViewById(R.id.enter_airType);
        output = (TextView)findViewById(R.id.output);


        findViewById(R.id.complete_divingDetails).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viw) {
                try {

                    String input_duration = duration.getText().toString();
                    int d = Integer.parseInt(input_duration);
                    String input_maxDepth = maxDepth.getText().toString();
                    int mD = Integer.parseInt(input_maxDepth);
                    String input_avgDepth = avgDepth.getText().toString();
                    int aD = Integer.parseInt(input_avgDepth);
                    String input_temp = temp.getText().toString();
                    int t = Integer.parseInt(input_temp);
                    String input_visibility = visibility.getText().toString();
                    int v = Integer.parseInt(input_visibility);
                    String input_pressureStart = pressureStart.getText().toString();
                    int pS = Integer.parseInt(input_pressureStart);
                    String input_pressureEnd = pressureEnd.getText().toString();
                    int pE = Integer.parseInt(input_pressureEnd);
                    String input_airType = airType.getText().toString();
                    int aT = Integer.parseInt(input_duration);

                    if (input_duration.isEmpty() ||
                            input_maxDepth.isEmpty() ||
                            input_avgDepth.isEmpty() ||
                            input_temp.isEmpty() ||
                            input_visibility.isEmpty() ||
                            input_pressureStart.isEmpty() ||
                            input_pressureEnd.isEmpty() ||
                            input_airType.isEmpty()) {  //activ != null || cond != null

                        throw new InputMismatchException("Please Enter the following details then press complete and then continue");
                    }
                    diveDetails = new DiveDetails(d, mD, aD, t, v, pS, pE, aT, activ, cond);
                    output.setText(diveDetails.toString());
                } catch (InputMismatchException e) {

                    Toast.makeText(DivingInformation1.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });


        continueDiveDetails = (Button) findViewById(R.id.continue_next);

        continueDiveDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(getApplicationContext(), OtherDivingDetails.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(DivingInformation1.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        back = (Button) findViewById(R.id.back_to_locationDetails);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DivingLocation.class);
                startActivity(intent);
            }
        });

    }

    public static DiveDetails getData() {
        return diveDetails;
    }
}





































