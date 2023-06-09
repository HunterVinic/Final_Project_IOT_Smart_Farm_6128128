package com.example.finalexam;

import static com.example.finalexam.R.layout.main_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainPage extends AppCompatActivity {

    Button buttonON;
    Button buttonOFF;
    Button monitor;
    Button settime;
    Button manual;
    TextView textView1;
    TextView textView2;
    SeekBar seekBar;
    DatabaseReference dref;
    String status;
    int fert =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(main_page);

        buttonON = findViewById(R.id.button2);
        buttonOFF = findViewById(R.id.button);


        seekBar = (SeekBar)findViewById(R.id.seekBar1);
        FirebaseDatabase database1 = FirebaseDatabase.getInstance();
        DatabaseReference myRef1 = database1.getReference("Fertilizer/Fertilizer2");
        myRef1.setValue(fert =0);
        dref = FirebaseDatabase.getInstance().getReference();
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data = String.valueOf(snapshot.child("Fertilizer/Fertilizer A").getValue());
                textView1.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data = String.valueOf(snapshot.child("Fertilizer/Fertilizer B").getValue());
                textView2.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        buttonOFF.setOnClickListener((view) -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Fertilizer/Fertilizer1");
            myRef.setValue(fert = 1);
        });

        buttonON.setOnClickListener((view) -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Fertilizer/Fertilizer2");
            myRef.setValue(fert =1);
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                               @Override
                                               public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                                   FirebaseDatabase database = FirebaseDatabase.getInstance();
                                                   DatabaseReference myRef = database.getReference("Moisture/Seekbar");
                                                   myRef.setValue(progress);
                                               }

                                               @Override
                                               public void onStartTrackingTouch(SeekBar seekBar) {

                                               }

                                               @Override
                                               public void onStopTrackingTouch(SeekBar seekBar) {

                                               }





                                           }
        );

    }
}


