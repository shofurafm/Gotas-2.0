package com.example.gotas20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gotas20.HelperClasses.SliderAdapter;

public class OnBoardingPage extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapt;
    TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_page);

        //Hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);

        //Call Adapter
        sliderAdapt = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapt);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
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
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}