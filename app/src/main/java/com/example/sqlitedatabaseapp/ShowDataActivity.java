package com.example.sqlitedatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDataActivity extends AppCompatActivity {
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        textView3 = findViewById(R.id.showemail);

        Intent i = getIntent();
        String mail = i.getStringExtra("KEY_EMAIL");

        textView3.setText(mail);

    }
}