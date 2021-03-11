package com.example.gotas20.TasSend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.gotas20.ProfilePage.PesananSaya;
import com.example.gotas20.R;
import com.example.gotas20.TasShop.ShopWaitingPage;

public class SendWaitingPage extends AppCompatActivity {

    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_waiting_page);

        btnBack = findViewById(R.id.backBtn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SendWaitingPage.this, PesananSaya.class);
                startActivity(intent);
            }
        });
    }
}