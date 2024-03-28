package com.example.sqlitedatabaseapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class MyuserbaseAdapter extends BaseAdapter {
    Context context;
    ArrayList<UserModel> user;
    public MyuserbaseAdapter(Context context, ArrayList<UserModel> user) {
        this.context = context;
        this.user = user;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contextview = layoutInflater.inflate(R.layout.activity_login,null);
        UserModel userModel = user.get(i);
        contextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = user.get(i).getUserid();
                String fn = user.get(i).getUserfirstname();
                String ln = user.get(i).getUserlastname();
                String email = user.get(i).getEmail();
                String pass = user.get(i).getPassword();

                Intent i = new Intent(context,LoginActivity.class);
                i.putExtra("KEY_USERID",id);
                i.putExtra("KEY_USERFN",fn);
                i.putExtra("KEY_USERLN",ln);
                i.putExtra("KEY_EMAIL",email);
                i.putExtra("KEY_PASS",pass);
            }
        });
        return contextview;
    }
}
