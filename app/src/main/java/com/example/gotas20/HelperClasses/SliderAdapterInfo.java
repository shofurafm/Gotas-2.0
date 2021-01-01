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

public class SliderAdapterInfo extends  RecyclerView.Adapter<SliderAdapterInfo.SliderViewHolder> {
    private List<SliderforInfo> sliderItems;
    private ViewPager2 viewPager2;

    public SliderAdapterInfo(List<SliderforInfo> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderAdapterInfo.SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderAdapterInfo.SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slides_info,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapterInfo.SliderViewHolder holder, int position) {
        holder.setImage(sliderItems.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder{
        private RoundedImageView imageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlideInfo);
        }

        void setImage(SliderforInfo sliderItem){
            imageView.setImageResource((sliderItem.getImage()));
        }
    }
}
