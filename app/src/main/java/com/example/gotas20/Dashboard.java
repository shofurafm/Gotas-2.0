package com.example.gotas20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.gotas20.HelperClasses.SliderAdapterInfo;
import com.example.gotas20.HelperClasses.SliderAdapterNews;
import com.example.gotas20.HelperClasses.SliderforInfo;
import com.example.gotas20.HelperClasses.SliderforNews;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    private ViewPager2 viewPager2, viewPager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        viewPager2 = findViewById(R.id.viewPagerSliderNews);

        // list image from drawable
        List<SliderforNews> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderforNews(R.drawable.example_4));
        sliderItems.add(new SliderforNews(R.drawable.example_4));
        sliderItems.add(new SliderforNews(R.drawable.example_4));

        viewPager2.setAdapter(new SliderAdapterNews(sliderItems, viewPager2));

        /*viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        })*/

        viewPager1 = findViewById(R.id.viewPagerSliderInfo);

        // list image from drawable
        List<SliderforInfo> sliderItemsInfo = new ArrayList<>();
        sliderItemsInfo.add(new SliderforInfo(R.drawable.example_4));
        sliderItemsInfo.add(new SliderforInfo(R.drawable.example_4));
        sliderItemsInfo.add(new SliderforInfo(R.drawable.example_4));

        viewPager1.setAdapter(new SliderAdapterInfo(sliderItemsInfo, viewPager1));
    }
}