package com.example.gotas20.ForgetPassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.gotas20.R;

public class MakeSelectionPage extends AppCompatActivity {

    Button smsOption, mailOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_selection_page);

        smsOption = findViewById(R.id.smsBtn);

        smsOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MakeSelectionPage.this, ResetPasswordPage.class);
                startActivity(intent);
            }
        });

        mailOption = findViewById(R.id.mailBtn);

        mailOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MakeSelectionPage.this, ResetPasswordPage.class);
                startActivity(intent);
            }
        });
    }
}