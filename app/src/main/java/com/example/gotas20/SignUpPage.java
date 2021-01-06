package com.example.gotas20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class SignUpPage extends AppCompatActivity {

    //Variables
    Button callSignIn, signedUp;
    SharedPreferences onBoardingScreen;
    TextInputLayout regName, regUsername, regEmail, regPhone, regPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        callSignIn = findViewById(R.id.btnRedirectLoginPage);

        callSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpPage.this, LoginPage.class);
                startActivity(intent);
            }
        });

        signedUp = findViewById(R.id.btnSignUp);

        signedUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(SignUpPage.this, OnBoardingPage.class);
                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

                if(isFirstTime){

                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent = new Intent(SignUpPage.this, OnBoardingPage.class);
                    startActivity(intent);
                    finish();

                }
                else{

                    Intent intent = new Intent(SignUpPage.this, Dashboard.class);
                    startActivity(intent);
                    finish();

                }
            }
        });
    }

    private Boolean validationName(){
        String value = regName.getEditText().getText().toString();

        if(value.isEmpty()){
            regName.setError("Tidak boleh kosong");
            return false;
        } else {
            regName.setError(null);
            regName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validationUsername(){
        String value = regUsername.getEditText().getText().toString();
        String noWhitespace = "(?=\\s+$)"; // or use this --> "\\A\\w{4,20}\\Z"

        if(value.isEmpty()){
            regUsername.setError("Tidak boleh kosong");
            return false;
        }
        else if(value.length()>=15){
            regUsername.setError("Username terlalu panjang");
            return false;
        }
        else if(!value.matches(noWhitespace)){
            regUsername.setError("Tidak boleh ada spasi");
            return false;
        }
        else {
            regUsername.setError(null);
            return true;
        }
    }

    private Boolean validationEmail(){
        String value = regEmail.getEditText().getText().toString();
        String emailPatern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(value.isEmpty()){
            regEmail.setError("Tidak boleh kosong");
            return false;
        }
        else if(!value.matches(emailPatern)){
            regEmail.setError("Email tidak tersedia");
            return false;
        }
        else {
            regEmail.setError(null);

            return true;
        }
    }

    private Boolean validationPhone(){
        String value = regPhone.getEditText().getText().toString();

        if(value.isEmpty()){
            regPhone.setError("Tidak boleh kosong");
            return false;
        }
        else {
            regPhone.setError(null);
            return true;
        }
    }

    private Boolean validationPassword(){
        String value = regPassword.getEditText().getText().toString();
        String passwordValidation = "^"+                 //start-of-string
                //"(?=.*[0-9])" +       // a digit must occur at least once
                //"(?=.*[a-z])" +      // a lower case letter must occur at least once
                //"(?=.*[A-Z])" +      // an upper case letter must occur at least once
                "(?=.*[@#$%^&+=])" + // a special character must occur at least once you can replace with your special characters
                "(?=\\S+$)" +         // no whitespace allowed in the entire string
                ".{4,}" +            // anything, at least six places though
                "$";                 // end-of-string

        if(value.isEmpty()){
            regPassword.setError("Tidak boleh kosong");
            return false;
        }
        else if(!value.matches(passwordValidation)){
            regPassword.setError("Password terlalu mudah");
            return false;
        }
        else {
            regPassword.setError(null);
            return true;
        }
    }

    public void registerUser(View view){

        if(!validationName() | !validationUsername() | !validationEmail() | !validationPhone() | !validationPassword()){
            return;
        }

        String fullname = regName.getEditText().getText().toString();
        String username = regUsername.getEditText().getText().toString();
        String email = regEmail.getEditText().getText().toString();
        String phoneNo = regPhone.getEditText().getText().toString();
        String password = regPassword.getEditText().getText().toString();

        /*UserHelperClass helperClass = new UserHelperClass(fullname, username, email, phoneNo, password);
        reference.child(username).setValue(helperClass);*/
    }
}