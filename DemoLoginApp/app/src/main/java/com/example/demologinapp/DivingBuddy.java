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
import com.example.otherjavafiles.DivePartner;

import java.util.InputMismatchException;

public class DivingBuddy extends AppCompatActivity {

    private static DivePartner divePartner;
    private static final String MY_PREFS = "MyPrefsFile";

    TextView output;
    EditText name, certNum, role;
    Button back;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diving_buddy);

        // Grabbing userID from previous page
        Bundle bundle = getIntent().getExtras();
        String userID = bundle.getString("ID");


        name = (EditText)findViewById(R.id.divebuddyname_input);
        certNum = (EditText)findViewById(R.id.certNumber_input);
        role = (EditText)findViewById(R.id.role_input);
        output = (TextView)findViewById(R.id.output);




        findViewById(R.id.complete_DiveBuddySection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    String inputName = name.getText().toString();
                    String inputCertNumber = certNum.getText().toString();
                    String inputRole = role.getText().toString();


                    if (inputName.isEmpty() || inputCertNumber.isEmpty() || inputRole.isEmpty()) {
                        throw new InputMismatchException("Please Enter the Name, CertNumber and role of the dive partner");
                    }
                    divePartner = new DivePartner(userID, -1, inputName,inputCertNumber,inputRole);
                    databaseHelper = new DatabaseHelper(DivingBuddy.this);
                    Boolean addDB = databaseHelper.addNewPartner(divePartner);
                    if (addDB) {
                        output.setText(divePartner.toString());
                        try {
                            divePartner.setPartnerID(Integer.parseInt(databaseHelper.getPartnerId(divePartner)));
                            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();
                            editor.putString("partnerID", databaseHelper.getPartnerId(divePartner));
                            editor.apply();
                        } catch (Exception e) {
                            Toast.makeText(DivingBuddy.this, "Problem getting partnerID", Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(DivingBuddy.this, "Problem adding to DB", Toast.LENGTH_LONG).show();
                    }
                }catch (InputMismatchException e) {

                    Toast.makeText(DivingBuddy.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });


        back = (Button)findViewById(R.id.back_to_otherDetails3);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),OtherDivingDetails.class);
                intent.putExtra("ID", userID);
                finish();
            }
        });

    }
    public static DivePartner getData(){
        return divePartner;
    }
}
