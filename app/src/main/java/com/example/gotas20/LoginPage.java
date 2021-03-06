package com.example.gotas20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gotas20.ForgetPassword.ForgetPassPage;

public class LoginPage extends AppCompatActivity {

    //Variables
    Button callSignUp, signedIn ;
    TextView forgetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        callSignUp = findViewById(R.id.btnRedirectSignUpPage);

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, SignUpPage.class);
                startActivity(intent);
                finish();
            }
        });

        signedIn = findViewById(R.id.btnLogin);

        signedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });

        forgetPassword = findViewById(R.id.btnForgetPass);

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, ForgetPassPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}