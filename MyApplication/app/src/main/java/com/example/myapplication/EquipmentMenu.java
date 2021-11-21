package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.otherjavafiles.DatabaseHelper;
import com.example.otherjavafiles.Equipment;
import com.example.otherjavafiles.EquipmentList;
import com.example.otherjavafiles.WildLife;

import java.util.ArrayList;
import java.util.List;

public class EquipmentMenu extends AppCompatActivity {

    // Set preferences
    private static  final String MY_PREFS = "MyPrefsFile";
    private static Equipment equipment;
    private static EquipmentList equipmentList;

    ListView lvEquipment;
    Button btnAddEquipment;
    ArrayAdapter customArrayAdapter;
    DatabaseHelper databaseHelper;
    SharedPreferences sharedPreferences;
    String userID;
    List<Equipment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_menu);

        // Set list and database
        lvEquipment = findViewById(R.id.lvEquipment);
        btnAddEquipment = findViewById(R.id.btnAddEquipment);
        sharedPreferences = this.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        userID = sharedPreferences.getString("userID", "Nothing");
        databaseHelper = new DatabaseHelper(EquipmentMenu.this);
        list = new ArrayList<Equipment>();
        equipmentList = new EquipmentList(list);


        //List all Equipment
        showAllEquipment(databaseHelper);


        //Grab selected data and send to be added to single log
        lvEquipment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                equipment = (Equipment) parent.getItemAtPosition(position);
                // Add wildlife to list that was selected and add to list

                list.add(equipment);
                Toast.makeText(EquipmentMenu.this, equipment.toString() + " was added to the list.", Toast.LENGTH_SHORT).show();
            }
        });
        /*
        Once add equipment button is clicked it send user to equipment details page to
        create a new equipment and display it on this page.
         */
        btnAddEquipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EquipmentInformation.class);
                startActivity(intent);
            }
        });
    }

    // Refresh the page once it has been returned
    @Override
    protected void onRestart() {
        super.onRestart();
        showAllEquipment(databaseHelper);
    }

    private void showAllEquipment(DatabaseHelper databaseHelper2) {
        customArrayAdapter = new ArrayAdapter<>(EquipmentMenu.this, android.R.layout.simple_expandable_list_item_1, databaseHelper2.getEquipment(userID));
        lvEquipment.setAdapter(customArrayAdapter);
    }

    public static EquipmentList getData() {return equipmentList;}
}