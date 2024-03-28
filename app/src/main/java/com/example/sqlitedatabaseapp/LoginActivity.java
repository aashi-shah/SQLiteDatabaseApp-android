package com.example.sqlitedatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText editText1,editText2;
    Button button;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText1 = findViewById(R.id.lemail);
        editText2 = findViewById(R.id.lpass);
        button = findViewById(R.id.login);

        db = new DatabaseHandler(this);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                Intent i1 = getIntent();
//                String id = i1.getStringExtra("KEY_USERID");
//                String fn = i1.getStringExtra("KEY_USERFN");
//                String ln = i1.getStringExtra("KEY_USERLN");
//                String mail = i1.getStringExtra("KEY_EMAIL");
//                String pass = i1.getStringExtra("KEY_PASS");

                String mail1 = editText1.getText().toString();
                String pass1 = editText2.getText().toString();

                UserModel userModel = db.getuserAllRecords(mail1,pass1);
                String mail = userModel.getEmail();
                Intent i = new Intent(LoginActivity.this,ShowDataActivity.class);
                    i.putExtra("KEY_EMAIL",mail);
                startActivity(i);

            }
        });
    }
}