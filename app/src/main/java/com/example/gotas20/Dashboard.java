package com.example.gotas20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gotas20.HelperClasses.SliderAdapterInfo;
import com.example.gotas20.HelperClasses.SliderAdapterNews;
import com.example.gotas20.HelperClasses.SliderforInfo;
import com.example.gotas20.HelperClasses.SliderforNews;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    private ViewPager2 viewPager2, viewPager1;
    RelativeLayout relativeLayout;
    Dialog myDialog;
    FloatingActionButton btnMenu;
    TextView txtRide, txtCar, txtFood, txtShop, txtSend, txtSchool;
    ImageButton btnRide, btnCar, btnFood, btnShop, btnSend, btnSchool;
    ImageView btnClose;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        viewPager2 = findViewById(R.id.viewPagerSliderNews);

        // list image from drawable
        List<SliderforNews> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderforNews(R.drawable.dashboard_item));
        sliderItems.add(new SliderforNews(R.drawable.dashboard_item));
        sliderItems.add(new SliderforNews(R.drawable.dashboard_item));

        viewPager2.setAdapter(new SliderAdapterNews(sliderItems, viewPager2));

        viewPager1 = findViewById(R.id.viewPagerSliderInfo);

        // list image from drawable
        List<SliderforInfo> sliderItemsInfo = new ArrayList<>();
        sliderItemsInfo.add(new SliderforInfo(R.drawable.dashboard_item));
        sliderItemsInfo.add(new SliderforInfo(R.drawable.dashboard_item));
        sliderItemsInfo.add(new SliderforInfo(R.drawable.dashboard_item));

        viewPager1.setAdapter(new SliderAdapterInfo(sliderItemsInfo, viewPager1));

        myDialog = new Dialog(this);
        btnMenu = findViewById(R.id.menuBtn);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopUp();
            }
        });

        animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        btnMenu.setAnimation(animation);

    }

    public void ShowPopUp(){
        myDialog.setContentView(R.layout.popup_menu);

        btnClose = (ImageView) myDialog.findViewById(R.id.closeBtn);

        btnRide = (ImageButton) myDialog.findViewById(R.id.tasRideBtn);
        btnCar = (ImageButton) myDialog.findViewById(R.id.tasCarBtn);
        btnFood = (ImageButton) myDialog.findViewById(R.id.tasFoodBtn);
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, TasFoodPage.class);
                startActivity(intent);
                finish();
            }
        });
        btnShop = (ImageButton) myDialog.findViewById(R.id.tasShopBtn);
        btnSend = (ImageButton) myDialog.findViewById(R.id.tasSendBtn);
        btnSchool = (ImageButton) myDialog.findViewById(R.id.tasSchoolBtn);

        txtRide = (TextView) myDialog.findViewById(R.id.rideTxt);
        txtCar = (TextView) myDialog.findViewById(R.id.carTxt);
        txtFood = (TextView) myDialog.findViewById(R.id.foodTxt);
        txtShop = (TextView) myDialog.findViewById(R.id.shopTxt);
        txtSend = (TextView) myDialog.findViewById(R.id.sendTxt);
        txtSchool = (TextView) myDialog.findViewById(R.id.schoolTxt);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}