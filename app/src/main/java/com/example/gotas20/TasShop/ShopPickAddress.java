package com.example.gotas20.TasShop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gotas20.R;
import com.example.gotas20.TasShopPage;

public class ShopPickAddress extends AppCompatActivity {

    Button btnConfirm;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_address);

        btnConfirm = findViewById(R.id.confirmBtn);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopPickAddress.this, ShopRequest.class);
                startActivity(intent);
            }
        });

        btnBack = findViewById(R.id.backBtn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopPickAddress.this, TasShopPage.class);
                startActivity(intent);
            }
        });
    }
}