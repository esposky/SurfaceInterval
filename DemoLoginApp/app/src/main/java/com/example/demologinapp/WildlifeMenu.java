package com.example.demologinapp;

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
import java.util.List;

public class WildlifeMenu extends AppCompatActivity {
    // Set preferences
    private static  final String MY_PREFS = "MyPrefsFile";
    private static WildLife wildLife;
    private static WildLifeList wildLifeList;
    //private static WildLifeList wildLifeList;

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
                // Add wildlife to list that was selected and add to list

                list.add(wildLife);
                Toast.makeText(WildlifeMenu.this, wildLife.toString() + " was added to the list.", Toast.LENGTH_SHORT).show();
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

    // Refresh the page once it has been returned
    @Override
    protected void onRestart() {
        super.onRestart();
        showAllWildlife(databaseHelper);
    }


    private void showAllWildlife(DatabaseHelper databaseHelper2) {
        customArrayAdapter = new ArrayAdapter<>(WildlifeMenu.this, android.R.layout.simple_expandable_list_item_1, databaseHelper2.getWildlife(userID));
        lvWildlife.setAdapter(customArrayAdapter);
    }

    // DO the same to get data from list
//    public static WildLife getData() {
//        return wildLife;
//    }
    public static WildLifeList getData() {return wildLifeList;}
}