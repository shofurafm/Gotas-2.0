package com.example.gotas20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gotas20.HelperClasses.SliderAdapter;

public class OnBoardingPage extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapt;
    TextView[] dots;
    Button getStartedButton;
    Animation animation;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding_page);

        //Hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        getStartedButton = findViewById(R.id.getStartedBtn);

        //Call Adapter
        sliderAdapt = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapt);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    /*
    public void skip(View view){
        startActivity(new Intent(this, Dashboard.class));
        finish();
    }*/

    public void next(View view){
        viewPager.setCurrentItem(currentPosition + 1);
    }

    private void addDots(int position){

        dots = new TextView[3];
        dotsLayout.removeAllViews();

        for(int i=0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(45);

            dotsLayout.addView(dots[i]);
        }

        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.darkOrange));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);

            currentPosition = position;

            if(position == 0){
                getStartedButton.setVisibility(View.INVISIBLE);
            }
            else if(position == 1){
                getStartedButton.setVisibility(View.INVISIBLE);
            }
            else{
                animation = AnimationUtils.loadAnimation(OnBoardingPage.this, R.anim.bottom_animation2);
                getStartedButton.setAnimation(animation);
                getStartedButton.setVisibility(View.VISIBLE);

                getStartedButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(OnBoardingPage.this, Dashboard.class);
                        startActivity(intent);
                    }
                });
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}