package com.example.demologinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.otherjavafiles.DatabaseHelper;
import com.example.otherjavafiles.Equipment;

import java.util.InputMismatchException;

public class EquipmentInformation extends AppCompatActivity {

    private static Equipment equipment;
    private static final String MY_PREFS = "MyPrefsFile";

    EditText type, make, model,price;
    TextView output;
    CheckBox cbRented;
    DatabaseHelper databaseHelper;

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_information);

        // Grabbing userID from shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        String userID = sharedPreferences.getString("userID", "0");

        type = (EditText)findViewById(R.id.typeOf_equipment);
        make = (EditText)findViewById(R.id.makeOf_equipment);
        model = (EditText)findViewById(R.id.modelOf_equipment);
        price = (EditText)findViewById(R.id.price_equipment);
        output = (TextView)findViewById(R.id.outputFor_equipment);
        cbRented = (CheckBox)findViewById(R.id.cbRented);
        back = (Button)findViewById(R.id.back_to_otherDetails2);
        databaseHelper = new DatabaseHelper(EquipmentInformation.this);

        findViewById(R.id.complete_equipmentSection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    String input_type = type.getText().toString();
                    String input_make = make.getText().toString();
                    String input_model = model.getText().toString();
                    Boolean rented = cbRented.isChecked();
                    String input_price = price.getText().toString();
                    Double x = 0.0;
                    if(!input_price.isEmpty()) { x = Double.parseDouble(input_price);}


                    //String input_rent = rent.getText().toString(); // represents input_price
                    //boolean r = Boolean.parseBoolean(input_rent); //  r for rent

                    if (input_type.isEmpty() || input_make.isEmpty() || input_model.isEmpty()){
                        throw new InputMismatchException("Please the following details and press complete");
                    }
                    else {
                        // If rented checkbox is checked for true
                        if (rented) {
                            equipment = new Equipment(userID, -1, input_type, input_make, input_model, true, x);
                            Boolean addEquipment = databaseHelper.addNewEquipment(equipment);
                            if (addEquipment) {
                                equipment.setEquipmentID(Integer.parseInt(databaseHelper.getEquipmentId(equipment)));
//                                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();
//                                editor.putString("equipmentID", databaseHelper.getEquipmentId(equipment));
//                                editor.apply();
                            }
                            else {
                                Toast.makeText(EquipmentInformation.this, "Problem adding rented equipment", Toast.LENGTH_LONG).show();
                            }
                        }
                        // If false, price is zero
                        else {
                            equipment = new Equipment(userID, -1, input_type, input_make, input_model, false, x);
                            Boolean addEquipment = databaseHelper.addNewEquipment(equipment);
                            if (addEquipment) {
//                                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS, MODE_PRIVATE).edit();
//                                editor.putString("equipmentID", databaseHelper.getEquipmentId(equipment));
//                                editor.apply();
                            }
                            else {
                                Toast.makeText(EquipmentInformation.this, "Problem adding non-rented equipment", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    output.setText(equipment.toString());

                }catch (InputMismatchException e) {

                    Toast.makeText(EquipmentInformation.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public static Equipment getData() {
        return equipment;
    }
}