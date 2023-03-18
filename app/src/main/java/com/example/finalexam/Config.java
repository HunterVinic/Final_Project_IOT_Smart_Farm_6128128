package com.example.finalexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Config extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner Spinner2;
    Spinner Spinner1;

    TextView day;

    TextView Hour;
    TextView Sec;

    TextView Moisture1;
    TextView Moisture2;
    TextView Moisture3;

    TextView N46;
    TextView N15;
    TextView Temp;
    TextView Fog;

    Button load;
    Button back;
    Button Search;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        Spinner1 = findViewById(R.id.spinner);
        String text = Spinner1.getSelectedItem().toString();




        Hour = findViewById(R.id.min);
        Sec = findViewById(R.id.sec);

        Moisture1 = findViewById(R.id.Moisture1_data);
        Moisture2 = findViewById(R.id.Moisture2_data);
        Moisture3 = findViewById(R.id.Moisture3_data);
        N46 = findViewById(R.id.NPK46_data);
        N15 = findViewById(R.id.NPK15_data);
        Temp = findViewById(R.id.Temp_data);
        Fog = findViewById(R.id.FOG_data);

        load = findViewById(R.id.load);
        back = findViewById(R.id.back);

        Search = findViewById(R.id.search);

        load.setOnClickListener(new View.OnClickListener() {

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef2 = database.getReference().child("DAY");
            @Override
            public void onClick(View view) {
                String Date = Hour.getText().toString();
                String Start = Sec.getText().toString();
                String MoistureA = Moisture1.getText().toString();
                String MoistureB = Moisture2.getText().toString();
                String MoistureC = Moisture3.getText().toString();
                String Nk46 = N46.getText().toString();
                String Nk15 = N15.getText().toString();
                String Temperature = Temp.getText().toString();
                String Fogg = Fog.getText().toString();
                String text = Spinner1.getSelectedItem().toString();


                myRef2.child(text).child("Hour").setValue(Date);
                myRef2.child(text).child("Sec").setValue(Start);
                myRef2.child(text).child("Moisture1").setValue(MoistureA);
                myRef2.child(text).child("Moisture2").setValue(MoistureB);
                myRef2.child(text).child("Moisture3").setValue(MoistureC);
                myRef2.child(text).child("Nk15").setValue(Nk15);
                myRef2.child(text).child("Nk46").setValue(Nk46);
                myRef2.child(text).child("Temperature").setValue(Temperature);
                myRef2.child(text).child("Fog").setValue(Fogg);

            }
        });

        Search.setOnClickListener(new View.OnClickListener() {

           DatabaseReference myRef2;
            @Override
            public void onClick(View view) {
                String text = Spinner1.getSelectedItem().toString();
                myRef2 = FirebaseDatabase.getInstance().getReference().child("DAY").child(text);

                myRef2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String data = String.valueOf(snapshot.child("Hour").getValue());
                        Hour.setText(data);
                        String data1 = String.valueOf(snapshot.child("Sec").getValue());
                        Sec.setText(data1);
                        String data2 = String.valueOf(snapshot.child("Moisture1").getValue());
                        Moisture1.setText(data2);
                        String data3 = String.valueOf(snapshot.child("Moisture2").getValue());
                        Moisture2.setText(data3);
                        String data4 = String.valueOf(snapshot.child("Moisture3").getValue());
                        Moisture3.setText(data4);
                        String data5 = String.valueOf(snapshot.child("NK15").getValue());
                        N15.setText(data5);
                        String data6 = String.valueOf(snapshot.child("NK46").getValue());
                        N46.setText(data6);
                        String data7 = String.valueOf(snapshot.child("Temperature").getValue());
                        Temp.setText(data7);
                        String data8 = String.valueOf(snapshot.child("Fog").getValue());
                        Fog.setText(data8);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Config.this,MainActivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


