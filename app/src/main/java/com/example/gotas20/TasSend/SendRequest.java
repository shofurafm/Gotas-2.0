package com.example.gotas20.TasSend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gotas20.R;
import com.example.gotas20.TasShop.ShopPickAddress;
import com.example.gotas20.TasShop.ShopRequest;
import com.example.gotas20.TasShop.ShopWaitingPage;

public class SendRequest extends AppCompatActivity {

    ImageView btnBack;
    Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_request);

        btnOrder = findViewById(R.id.orderBtn);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SendRequest.this, SendWaitingPage.class);
                startActivity(intent);
            }
        });

        btnBack = findViewById(R.id.backBtn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SendRequest.this, SendPickAddress.class);
                startActivity(intent);
            }
        });
    }

}