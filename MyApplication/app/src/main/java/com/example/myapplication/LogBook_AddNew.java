package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.otherjavafiles.DatabaseHelper;

public class LogBook_AddNew extends AppCompatActivity {

    EditText title, description;
    Button addDiveLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_book_add_new);



        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        addDiveLog = findViewById(R.id.addNewDivelog);

        addDiveLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!TextUtils.isEmpty(title.getText().toString()) && !TextUtils.isEmpty(description.getText().toString())) {
                    DatabaseHelper db = new DatabaseHelper(LogBook_AddNew.this);
                    //db.LogBook_AddNew(title.getText().toString(), description.getText().toString());

                    Intent intent = new Intent(LogBook_AddNew.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(LogBook_AddNew.this, "Both Fields Required", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}



