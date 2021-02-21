package com.example.gotas20.HelperClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.gotas20.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderAdapterFood2 extends  RecyclerView.Adapter<SliderAdapterFood2.SliderViewHolder>{
    private List<SliderFood2> sliderItems;
    private ViewPager2 viewPager2;

    public SliderAdapterFood2(List<SliderFood2> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderAdapterFood2.SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderAdapterFood2.SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_food_category2,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapterFood2.SliderViewHolder holder, int position) {
        holder.setImage(sliderItems.get(position));
        if(position == sliderItems.size() - 2){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder{
        private RoundedImageView imageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.slideFood2);
        }

        void setImage(SliderFood2 sf2){
            imageView.setImageResource((sf2.getImage()));
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };
}
