package com.example.gotas20.TasSend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gotas20.R;
import com.example.gotas20.TasSendPage;

public class SendPickAddress extends AppCompatActivity {

    Button btnConfirm;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_pick_address);

        btnConfirm = findViewById(R.id.confirmBtn);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SendPickAddress.this, SendRequest.class);
                startActivity(intent);
            }
        });

        btnBack = findViewById(R.id.backBtn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SendPickAddress.this, TasSendPage.class);
                startActivity(intent);
            }
        });
    }
}