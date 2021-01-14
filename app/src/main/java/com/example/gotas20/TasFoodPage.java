package com.example.gotas20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.gotas20.HelperClasses.SliderAdapterFood3;
import com.example.gotas20.HelperClasses.SliderAdapterNews;
import com.example.gotas20.HelperClasses.SliderFood3;
import com.example.gotas20.HelperClasses.SliderforNews;

import java.util.ArrayList;
import java.util.List;

public class TasFoodPage extends AppCompatActivity {

    private ViewPager2 viewPager3;
    private Handler sliderHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tas_food_page);

        viewPager3 = findViewById(R.id.viewPagerRestoCategories);

        List<SliderFood3> sliderFood3 = new ArrayList<>();
        sliderFood3.add(new SliderFood3(R.drawable.boarding_1));
        sliderFood3.add(new SliderFood3(R.drawable.boarding_2));
        sliderFood3.add(new SliderFood3(R.drawable.boarding_3));

        viewPager3.setAdapter(new SliderAdapterFood3(sliderFood3, viewPager3));

        viewPager3.setClipToPadding(false);
        viewPager3.setClipChildren(false);
        viewPager3.setOffscreenPageLimit(3);
        viewPager3.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager3.setPageTransformer(compositePageTransformer);

        viewPager3.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager3.setCurrentItem(viewPager3.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }
}