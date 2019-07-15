package com.example.neilbryanlagrimas.nbpo_gameapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Create_Room_Activity extends AppCompatActivity {

    EditText Lobby;
    Button Create;

    Create_Lobby create_lobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__room_);

        Lobby = (EditText) findViewById(R.id.Lobby);
        Create = (Button)findViewById(R.id.Create);

        create_lobby = new Create_Lobby();

        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Create_Room_Activity.this,Question_Maker.class);
                intent.putExtra("Room_name",Lobby.getText().toString().trim());
                startActivity(intent);
                Toast.makeText(Create_Room_Activity.this,"Data Inserted",Toast.LENGTH_LONG).show();
            }
        });
    }
}
