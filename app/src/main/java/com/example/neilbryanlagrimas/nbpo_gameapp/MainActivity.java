package com.example.neilbryanlagrimas.nbpo_gameapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText LName;
    Button Save;

    DatabaseReference databaseReference;
    Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.Name);
        LName = (EditText) findViewById(R.id.LName);
        Save = (Button)findViewById(R.id.Save);


        member = new Member();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Member");

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                member.setName(Name.getText().toString().trim());
                member.setLName(LName.getText().toString().trim());


                databaseReference.child("member1").setValue(member);
                Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
            }
        });






    }

    }

