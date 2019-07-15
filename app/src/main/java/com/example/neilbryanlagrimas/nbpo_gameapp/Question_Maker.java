package com.example.neilbryanlagrimas.nbpo_gameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question_Maker extends AppCompatActivity {

    private String sessionId = "";

    Button save_question;
    EditText choice1 ,choice2 ,question;

    DatabaseReference databaseReference;
    Create_Question create_question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question__maker);


        sessionId = getIntent().getStringExtra("Room_name");
        Toast.makeText(Question_Maker.this,sessionId,Toast.LENGTH_LONG).show();
        save_question = (Button)findViewById(R.id.save_question);
        question = (EditText)findViewById(R.id.question);
        choice1 = (EditText)findViewById(R.id.choice1);
        choice2 = (EditText)findViewById(R.id.choice2);

        create_question = new Create_Question();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Lobby");


        save_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create_question.setQuestion_Name(question.getText().toString().trim());
                create_question.setChoice_1(choice1.getText().toString().trim());
                create_question.setChoice_2(choice2.getText().toString().trim());
                databaseReference.child(sessionId).setValue(create_question);


                Toast.makeText(Question_Maker.this,"Data Inserted",Toast.LENGTH_LONG).show();
                startActivity(new Intent(Question_Maker.this,MainActivity.class));
                finish();

            }
        });




    }
}
