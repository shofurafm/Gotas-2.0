package com.example.gotas20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gotas20.TasShop.ShopPickAddress;
import com.google.android.material.textfield.TextInputLayout;

public class TasShopPage extends AppCompatActivity {

    Button btnContinue;
    ImageView btnBack;
    TextInputLayout shopItem, shopPrice, shopStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tas_shop_page);

        btnContinue = findViewById(R.id.continueBtn);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TasShopPage.this, ShopPickAddress.class);
                startActivity(intent);
            }
        });

        btnBack = findViewById(R.id.backBtn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TasShopPage.this, Dashboard.class);
                startActivity(intent);
            }
        });

    }

    private Boolean validationItem(){
        String value = shopItem.getEditText().getText().toString();

        if(value.isEmpty()){
            shopItem.setError("Tidak boleh kosong");
            return false;
        } else {
            shopItem.setError(null);
            shopItem.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validationItemPrice(){
        String value = shopPrice.getEditText().getText().toString();

        if(value.isEmpty()){
            shopPrice.setError("Tidak boleh kosong");
            return false;
        }
        else {
            shopPrice.setError(null);
            return true;
        }
    }

    private Boolean validationStore(){
        String value = shopStore.getEditText().getText().toString();

        if(value.isEmpty()){
            shopStore.setError("Tidak boleh kosong");
            return false;
        } else {
            shopStore.setError(null);
            shopStore.setErrorEnabled(false);
            return true;
        }
    }

    public void continueBtn(View view){

        if(!validationItem() | !validationItemPrice() | !validationStore()){
            return;
        }

        String ItemName = shopItem.getEditText().getText().toString();
        String ItemPrice = shopPrice.getEditText().getText().toString();
        String StoreName = shopStore.getEditText().getText().toString();
    }
}