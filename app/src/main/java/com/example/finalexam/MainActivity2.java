package com.example.finalexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.internal.ManufacturerUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity2 extends AppCompatActivity {

    Button buttonON1;
    Button buttonOFF1;

    Button buttonON2;
    Button buttonOFF2;

    Button buttonON3;
    Button buttonOFF3;

    Button buttonON4;
    Button buttonOFF4;

    Button Back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonON1 = findViewById(R.id.on1);
        buttonOFF1 = findViewById(R.id.off1);

        buttonON2 = findViewById(R.id.on2);
        buttonOFF2 = findViewById(R.id.off2);

        buttonON3 = findViewById(R.id.on3);
        buttonOFF3 = findViewById(R.id.off3);

        buttonON4 = findViewById(R.id.on4);
        buttonOFF4 = findViewById(R.id.off4);

        Back = findViewById(R.id.back);



        buttonOFF1.setOnClickListener((view) -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Manual/Port1");
            myRef.setValue( "OFF");
        });

        buttonON1.setOnClickListener((view) -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Manual/Port1");
            myRef.setValue("ON");
        });

        buttonOFF2.setOnClickListener((view) -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Manual/Port2");
            myRef.setValue( "OFF");
        });

        buttonON2.setOnClickListener((view) -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Manual/Port2");
            myRef.setValue("ON");
        });

        buttonOFF3.setOnClickListener((view) -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Manual/NPK-15");
            myRef.setValue( "OFF");
        });

        buttonON3.setOnClickListener((view) -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Manual/NPK-15");
            myRef.setValue("ON");
        });

        buttonOFF4.setOnClickListener((view) -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Manual/NPK-46");
            myRef.setValue( "OFF");
        });

        buttonON4.setOnClickListener((view) -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Manual/NPK-46");
            myRef.setValue("ON");
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);

            }
        });



    }
}


