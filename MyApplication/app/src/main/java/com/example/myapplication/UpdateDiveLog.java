package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDiveLog extends AppCompatActivity {

    EditText divelog_title,divelog_description;
    Button updateNotes;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_dive_log);

        divelog_title=findViewById(R.id.title);
        divelog_description=findViewById(R.id.description);
        updateNotes=findViewById(R.id.updateDivelog);

        Intent i =getIntent();
        divelog_title.setText(i.getStringExtra("title"));
        divelog_description.setText(i.getStringExtra("description"));
        id=i.getStringExtra("id");

        updateNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!TextUtils.isEmpty(divelog_title.getText().toString()) && !TextUtils.isEmpty(divelog_description.getText().toString()))
                {

//                    AddNewDiveLogDatabase db = new AddNewDiveLogDatabase(UpdateDiveLog.this);
//                    db.updateNotes(divelog_title.getText().toString(),divelog_description.getText().toString(),id);

                    Intent i=new Intent(UpdateDiveLog.this,MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                    finish();


                }
                else
                {
                    Toast.makeText(UpdateDiveLog.this, "Both Fields Required", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}
