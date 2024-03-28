package com.example.sqlitedatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    EditText editText1,editText2,editText3,editText4,editText5,editText6;
    Button button;
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editText1 = findViewById(R.id.sfn);
        editText2 = findViewById(R.id.sln);
        editText3 = findViewById(R.id.semail);
        editText4 = findViewById(R.id.snumber);
        editText5 = findViewById(R.id.spass);
        editText6 = findViewById(R.id.scpass);
        button = findViewById(R.id.signup);

        db = new DatabaseHandler(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = editText5.getText().toString();
                String cpass = editText6.getText().toString();
                if (cpass.equals(pass)){
                    String fn = editText1.getText().toString();
                    String ln = editText2.getText().toString();
                    String mail = editText3.getText().toString();
                    String ph = editText4.getText().toString();
                    String password = editText5.getText().toString();

                    UserModel userModel = new UserModel();
                    userModel.setUserfirstname(fn);
                    userModel.setUserlastname(ln);
                    userModel.setEmail(mail);
                    userModel.setPhone(ph);
                    userModel.setPassword(password);

                    db.userInsert(userModel);

                    Intent i = new Intent(SignupActivity.this,LoginActivity.class);
                    startActivity(i);

                }else{
                    editText6.setError("Enter valid password.");
                }
            }
        });
    }
}