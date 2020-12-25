package com.example.gotas20.ForgetPassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gotas20.LoginPage;
import com.example.gotas20.R;

public class ForgetPassPage extends AppCompatActivity {

    Button nextForgetPassBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass_page);

        nextForgetPassBtn = findViewById(R.id.btnResetEmail);

        nextForgetPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPassPage.this, MakeSelectionPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}