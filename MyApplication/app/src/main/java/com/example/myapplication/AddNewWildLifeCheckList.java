package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AddNewWildLifeCheckList extends AppCompatActivity {

    // declare the required views variable
    private EditText user_input;
    private LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_wild_life_check_list);


        linearLayout = findViewById(R.id.linear_layout);

        user_input = findViewById(R.id.enter_wildlife);

        linearLayout = findViewById(R.id.linear_layout);

        Button addwildlife = findViewById(R.id.add_wildlife_button);
        addwildlife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = user_input.getText().toString();
                if (!name.isEmpty()) {
                    CheckBox checkBox = new CheckBox(AddNewWildLifeCheckList.this);
                    checkBox.setText(name);
                    linearLayout.addView(checkBox);
                } else
                    Toast.makeText(AddNewWildLifeCheckList.this, "Please enter wildlife seen on dive!", Toast.LENGTH_LONG).show();
            }
        });






    }
}