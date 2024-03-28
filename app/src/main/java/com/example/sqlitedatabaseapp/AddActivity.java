package com.example.sqlitedatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText editText1,editText2;
    Button button1,button2;
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editText1 = findViewById(R.id.fn);
        editText2 = findViewById(R.id.ln);

        button1 = findViewById(R.id.add);
        button2 = findViewById(R.id.display);
        db = new DatabaseHandler(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn = editText1.getText().toString();
                String ln = editText2.getText().toString();

                DriverModel driverModel = new DriverModel();
                driverModel.setFirstname(fn);
                driverModel.setLastname(ln);

                db.insertRecord(driverModel);
                editText1.setText("");
                editText2.setText("");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddActivity.this,DisplayActivity.class);
                startActivity(i);
            }
        });
    }
}