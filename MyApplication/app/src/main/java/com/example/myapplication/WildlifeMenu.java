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
import com.example.otherjavafiles.WildLife;
import com.example.otherjavafiles.WildLifeList;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class WildlifeMenu extends AppCompatActivity {

    // Set preferences
    private static  final String MY_PREFS = "MyPrefsFile";
    private static WildLife wildLife;
    private  static WildLifeList wildLifeList;

    ListView lvWildlife;
    ArrayAdapter customArrayAdapter;
    DatabaseHelper databaseHelper;
    Button btnAddWildlife;
    SharedPreferences sharedPreferences;
    String userID;
    List<WildLife> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wildlife_menu);


        // Set list and database
        lvWildlife = findViewById(R.id.lvWildlife);
        btnAddWildlife = findViewById(R.id.btnAddWildlife);
        sharedPreferences = this.getSharedPreferences(MY_PREFS, MODE_PRIVATE);
        userID = sharedPreferences.getString("userID", "Nothing");
        databaseHelper = new DatabaseHelper(WildlifeMenu.this);
        list = new ArrayList<WildLife>();
        wildLifeList = new WildLifeList(list);

        //List all wildlife inside of the list view
        showAllWildlife(databaseHelper);

        //Grab selected data and send to be added to single log
        lvWildlife.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                wildLife = (WildLife) parent.getItemAtPosition(position);
                list.add(wildLife);
                Toast.makeText(WildlifeMenu.this, wildLife.toString() + " was the selected wildlife.", Toast.LENGTH_SHORT).show();
            }
        });

        // Once add wildlife button is clicked it send user to wildlife details page to
        // create a new wildlife and display it on this page.
        btnAddWildlife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WildLifeDetails.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showAllWildlife(databaseHelper);
    }

    private void showAllWildlife(DatabaseHelper databaseHelper2) {
        customArrayAdapter = new ArrayAdapter<>(WildlifeMenu.this, android.R.layout.simple_expandable_list_item_1, databaseHelper2.getWildlife(userID));
        lvWildlife.setAdapter(customArrayAdapter);
    }

    public static WildLifeList getData() {
        return wildLifeList;
    }
}