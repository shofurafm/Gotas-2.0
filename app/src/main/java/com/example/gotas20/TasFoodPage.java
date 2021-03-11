package com.example.gotas20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gotas20.HelperClasses.SliderAdapterFood3;
import com.example.gotas20.HelperClasses.SliderAdapterNews;
import com.example.gotas20.HelperClasses.SliderFood2;
import com.example.gotas20.HelperClasses.SliderFood3;
import com.example.gotas20.HelperClasses.SliderforNews;
import com.example.gotas20.TasFood.MurahResto;
import com.example.gotas20.TasFood.PopulerResto;
import com.example.gotas20.TasFood.TwentyfourResto;
import com.example.gotas20.TasShop.ShopPickAddress;

import java.util.ArrayList;
import java.util.List;

public class TasFoodPage extends AppCompatActivity {

    Button cat1, cat2, cat3;
    ImageView btnBack;
    private ViewPager2 viewPager3, viewPager2;
    private Handler sliderHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tas_food_page);

        btnBack = findViewById(R.id.tasFoodBackBtn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TasFoodPage.this, Dashboard.class);
                startActivity(intent);
            }
        });

        cat1 = findViewById(R.id.tsCategory1_Btn);

        cat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TasFoodPage.this, TwentyfourResto.class);
                startActivity(intent);
                finish();
            }
        });

        cat2 = findViewById(R.id.tsCategory2_Btn);

        cat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TasFoodPage.this, PopulerResto.class);
                startActivity(intent);
                finish();
            }
        });

        cat3 = findViewById(R.id.tsCategory3_Btn);

        cat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TasFoodPage.this, MurahResto.class);
                startActivity(intent);
                finish();
            }
        });

        //near resto
        viewPager3 = findViewById(R.id.viewPagerNearResto);

        List<SliderFood3> sliderFood3 = new ArrayList<>();
        sliderFood3.add(new SliderFood3(R.drawable.ts_near1));
        sliderFood3.add(new SliderFood3(R.drawable.ts_near2));
        sliderFood3.add(new SliderFood3(R.drawable.ts_near3));
        sliderFood3.add(new SliderFood3(R.drawable.ts_near4));

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

        //popular resto
        viewPager2 = findViewById(R.id.viewPagerPopularResto);

        List<SliderFood2> sliderFood2 = new ArrayList<>();
        sliderFood2.add(new SliderFood2(R.drawable.ts_near1));
        sliderFood2.add(new SliderFood2(R.drawable.ts_near2));
        sliderFood2.add(new SliderFood2(R.drawable.ts_near3));
        sliderFood2.add(new SliderFood2(R.drawable.ts_near4));

        viewPager2.setAdapter(new SliderAdapterFood3(sliderFood3, viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer2 = new CompositePageTransformer();
        compositePageTransformer2.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer2.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer2);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
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
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
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