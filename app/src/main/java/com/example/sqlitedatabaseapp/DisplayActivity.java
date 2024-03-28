package com.example.sqlitedatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    ListView listView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent in1 = getIntent();
        listView = findViewById(R.id.listview);
        button = findViewById(R.id.add_driver);

        DatabaseHandler db = new DatabaseHandler(this);
        ArrayList<DriverModel> drivernames = db.getAllRecords();
        MybaseAdapter mybaseAdapter = new MybaseAdapter(this,drivernames);
        listView.setAdapter(mybaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String fn = drivernames.get(i).getFirstname();
                String ln = drivernames.get(i).getLastname();
                String id = drivernames.get(i).getId();

                Intent in2 = new Intent(DisplayActivity.this,UpdateActivity.class);

                in2.putExtra("KEY_FN",fn);
                in2.putExtra("KEY_LN",ln);
                in2.putExtra("KEY_ID",id);
                startActivity(in2);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DisplayActivity.this,AddActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}