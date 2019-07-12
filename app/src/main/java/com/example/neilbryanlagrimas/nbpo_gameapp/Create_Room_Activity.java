package com.example.neilbryanlagrimas.nbpo_gameapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Create_Room_Activity extends AppCompatActivity {

    EditText Lobby;
    Button Create;

    DatabaseReference databaseReference;
    Create_Lobby create_lobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__room_);


        Lobby = (EditText) findViewById(R.id.Lobby);
        Create = (Button)findViewById(R.id.Create);


        create_lobby = new Create_Lobby();

        databaseReference = FirebaseDatabase.getInstance().getReference();


        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create_lobby.setLobby_name(Lobby.getText().toString().trim());
                databaseReference.child("Lobby").setValue(create_lobby);


                Toast.makeText(Create_Room_Activity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                startActivity(new Intent(Create_Room_Activity.this,MainActivity.class));
            }
        });
    }
}
