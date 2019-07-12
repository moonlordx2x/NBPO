package com.example.neilbryanlagrimas.nbpo_gameapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Splash_Activity extends AppCompatActivity {

    EditText Username;
    Button Save;

    DatabaseReference databaseReference;
    User user;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);


        Username = (EditText) findViewById(R.id.Username);
        Save = (Button)findViewById(R.id.Save);


        user = new User();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setUsername(Username.getText().toString().trim());
                databaseReference.child("User").setValue(user);

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("Username", Username.getText().toString());
                editor.commit();

                Toast.makeText(Splash_Activity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                startActivity(new Intent(Splash_Activity.this,MainActivity.class));
            }
        });

    }
}
