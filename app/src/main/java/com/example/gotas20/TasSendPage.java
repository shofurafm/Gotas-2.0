package com.example.gotas20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gotas20.TasSend.SendPickAddress;
import com.example.gotas20.TasShop.ShopPickAddress;
import com.google.android.material.textfield.TextInputLayout;

public class TasSendPage extends AppCompatActivity {

    Button btnContinue;
    ImageView btnBack;
    TextInputLayout itemPackage, recipientName, recipientPhone, senderPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tas_send_page);

        btnContinue = findViewById(R.id.continueBtn);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TasSendPage.this, SendPickAddress.class);
                startActivity(intent);
            }
        });

        btnBack = findViewById(R.id.backBtn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TasSendPage.this, Dashboard.class);
                startActivity(intent);
            }
        });

    }

    private Boolean validationItem(){
        String value = itemPackage.getEditText().getText().toString();

        if(value.isEmpty()){
            itemPackage.setError("Tidak boleh kosong");
            return false;
        } else {
            itemPackage.setError(null);
            itemPackage.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validationRecipientName(){
        String value = recipientName.getEditText().getText().toString();

        if(value.isEmpty()){
            recipientName.setError("Tidak boleh kosong");
            return false;
        }
        else {
            recipientName.setError(null);
            recipientName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validationRecipientPhone(){
        String value = recipientPhone.getEditText().getText().toString();

        if(value.isEmpty()){
            recipientPhone.setError("Tidak boleh kosong");
            return false;
        } else {
            recipientPhone.setError(null);
            recipientPhone.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validationSenderPhone(){
        String value = senderPhone.getEditText().getText().toString();

        if(value.isEmpty()){
            senderPhone.setError("Tidak boleh kosong");
            return false;
        } else {
            senderPhone.setError(null);
            senderPhone.setErrorEnabled(false);
            return true;
        }
    }

    public void continueBtn(View view){

        if(!validationItem() | !validationRecipientName() | !validationRecipientPhone() | !validationSenderPhone()){
            return;
        }

        String ItemName = itemPackage.getEditText().getText().toString();
        String RecipientName = recipientName.getEditText().getText().toString();
        String RecipientPhone = recipientPhone.getEditText().getText().toString();
        String SenderPhone = senderPhone.getEditText().getText().toString();
    }
}