package com.example.neilbryanlagrimas.nbpo_gameapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button Start , Quit;
    TextView User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String value = preferences.getString("Username", "");

        User = (TextView)findViewById(R.id.User);
        Start = (Button)findViewById(R.id.Start);
        Quit = (Button)findViewById(R.id.Quit);

        User.setText(value);



        Start.setOnClickListener(this);

        if(value == ""){
            startActivity(new Intent(MainActivity.this,Splash_Activity.class));
        }
        else {
            Toast.makeText(this,value,Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onClick(View v) {
        if(v == Start){
            startActivity(new Intent(MainActivity.this,Create_Room_Activity.class));
        }
    }
}

