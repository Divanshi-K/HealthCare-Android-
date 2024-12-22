package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit = findViewById(R.id.C_FD_Back);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctorActivity.this,HomeActivity.class));
            }
        });

        CardView F_phy = findViewById(R.id.C_FD_Phy);
        F_phy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                i.putExtra("title","Family Physicians");
                startActivity(i);
            }
        });

        CardView dietician = findViewById(R.id.C_FD_dietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                i.putExtra("title","Dietician");
                startActivity(i);
            }
        });

        CardView dentist = findViewById(R.id.C_FD_Dentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                i.putExtra("title","Dentist");
                startActivity(i);
            }
        });

        CardView surgeon = findViewById(R.id.C_FD_Surgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                i.putExtra("title","Surgeon");
                startActivity(i);
            }
        });

        CardView cardio = findViewById(R.id.C_FDCardio);
        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                i.putExtra("title","Cardiologists");
                startActivity(i);
            }
        });
    }
}