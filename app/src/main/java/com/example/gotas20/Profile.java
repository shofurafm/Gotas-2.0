package com.example.gotas20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gotas20.ProfilePage.Bantuan;
import com.example.gotas20.ProfilePage.KebijakanPrivacy;
import com.example.gotas20.ProfilePage.KetentuanLayanan;
import com.example.gotas20.ProfilePage.PesananSaya;

public class Profile extends AppCompatActivity {

    ImageView btnBack;
    Button opt1, opt2, opt3, opt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnBack = findViewById(R.id.homebtn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });

        opt1 = findViewById(R.id.option1);

        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, PesananSaya.class);
                startActivity(intent);
                finish();
            }
        });

        opt2 = findViewById(R.id.option2);

        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Bantuan.class);
                startActivity(intent);
                finish();
            }
        });

        opt3 = findViewById(R.id.option3);

        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, KebijakanPrivacy.class);
                startActivity(intent);
                finish();
            }
        });

        opt4 = findViewById(R.id.option4);

        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, KetentuanLayanan.class);
                startActivity(intent);
                finish();
            }
        });
    }
}