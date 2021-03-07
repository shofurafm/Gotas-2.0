package com.example.gotas20.ProfilePage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.gotas20.Dashboard;
import com.example.gotas20.Notification;
import com.example.gotas20.Profile;
import com.example.gotas20.R;

public class PesananSaya extends AppCompatActivity {

    ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan_saya);

        btnBack = findViewById(R.id.backBtn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PesananSaya.this, Profile.class);
                startActivity(intent);
                finish();
            }
        });
    }
}