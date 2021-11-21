package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.otherjavafiles.DatabaseHelper;
import com.example.otherjavafiles.WildLife;
import com.example.otherjavafiles.WildLifeList;

import java.util.InputMismatchException;

public class WildLifeDetails extends AppCompatActivity {

    private static WildLife wildLife;
    private static WildLifeList wildLifeList;
    private static final String MY_PREFS = "MyPrefsFile";

    EditText species, type;
    TextView output;
    Button back;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wild_life_details);

        // Grabbing userID from previous page
//        Bundle bundle = getIntent().getExtras();
//        String userID = bundle.getString("ID");
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        String userID = sharedPreferences.getString("userID", "0");

        type = (EditText)findViewById(R.id.wild_lifeType);
        species = (EditText) findViewById(R.id.wild_lifeSpecies);
        output = (TextView) findViewById(R.id.wild_lifeOutput);
        back = (Button) findViewById(R.id.back_to_otherDetails1);

        findViewById(R.id.complete_wildLifeSection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    String inputType = type.getText().toString();
                    String inputSpecies = species.getText().toString();

                    if (inputType.isEmpty() || inputSpecies.isEmpty()) {
                        throw new InputMismatchException("Please enter wild life information and press complete");
                    }
                    wildLife = new WildLife(userID, -1, inputType,inputSpecies);

                    // Add to database
                    databaseHelper = new DatabaseHelper(WildLifeDetails.this);
                    Boolean wildlifeInsert = databaseHelper.addNewWildlife(wildLife);
                    if (wildlifeInsert) {
                        // Set wildlifelist later
                        wildLife.setWildlifeID(Integer.parseInt(databaseHelper.getWildlifeId(wildLife)));
                        output.setText(wildLife.toString());
//                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();
//                        editor.putString("wildlifeID", databaseHelper.getWildlifeId(wildLife));
//                        editor.apply();
                    }
                    else {
                        Toast.makeText(WildLifeDetails.this, "Could not add to database", Toast.LENGTH_SHORT).show();
                    }
                } catch (InputMismatchException e) {

                    Toast.makeText(WildLifeDetails.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public static WildLife getData() {
        return wildLife;
    }
}