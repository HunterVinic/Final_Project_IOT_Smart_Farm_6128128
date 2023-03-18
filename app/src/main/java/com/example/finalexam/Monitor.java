package com.example.finalexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Monitor extends AppCompatActivity {



    TextView moisture1;
    TextView moisture2;
    TextView moisture3;
    TextView nk15;
    TextView nk46;
    Button Back;

    DatabaseReference dref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        Back = findViewById(R.id.back);
        moisture1 = findViewById(R.id.m1_view);
        moisture2 = findViewById(R.id.m2_view);
        moisture3 = findViewById(R.id.m3_view);
        nk15 = findViewById(R.id.nk15_view);
        nk46 = findViewById(R.id.nk46_view);



        dref = FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data = String.valueOf(snapshot.child("Monitor/Moisture-1").getValue());
                moisture1.setText(data);
                String data1 = String.valueOf(snapshot.child("Monitor/Moisture-2").getValue());
                moisture2.setText(data1);
                String data2 = String.valueOf(snapshot.child("Monitor/Moisture-3").getValue());
                moisture3.setText(data2);
                String data3 = String.valueOf(snapshot.child("Monitor/NK-15").getValue());
                nk15.setText(data3);
                String data4 = String.valueOf(snapshot.child("Monitor/NK-46").getValue());
                nk46.setText(data4);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Monitor.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}


