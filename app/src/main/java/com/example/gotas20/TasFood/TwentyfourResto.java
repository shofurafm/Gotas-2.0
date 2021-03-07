package com.example.gotas20.TasFood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.gotas20.Profile;
import com.example.gotas20.ProfilePage.Bantuan;
import com.example.gotas20.R;
import com.example.gotas20.TasFoodPage;

public class TwentyfourResto extends AppCompatActivity {

    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twentyfour_resto);

        btnBack = findViewById(R.id.backBtn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwentyfourResto.this, TasFoodPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}