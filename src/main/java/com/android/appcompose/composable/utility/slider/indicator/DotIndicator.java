package com.android.appcompose.composable.utility.slider.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.android.appcompose.R;
import com.android.appcompose.composable.utility.slider.viewpager2.ImageSliderView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class DotIndicator extends LinearLayout {
    public  TabLayout tabLayout;
    public ViewPager2 viewPager2;
    public ImageSliderView imageSliderView;
    public DotIndicator(@NonNull Context context, ViewPager2 pager2){
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_dotindicator, this, true);
        tabLayout = (TabLayout) getChildAt(0);
        tabLayout.setBackgroundColor(Color.TRANSPARENT);
        new TabLayoutMediator(tabLayout,pager2,(tab, position) -> {

        }).attach();
    }
    public DotIndicator(@NonNull Context context) {
        super(context);


    }

    public DotIndicator(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ImagePagerView);
//        try
//        {
//
//            int sliderId = a.getResourceId(R.styleable.DotIndicator_slider, 0);
//            if (sliderId != 0) {
//                imageSliderView = findViewById(sliderId);
//
//            }
//
//
//            Log.d("STYLABLE","hello");
//
//        }
//        finally
//        {
//            a.recycle();
//        }
//
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        inflater.inflate(R.layout.view_dotindicator, this, true);
//        tabLayout = (TabLayout) getChildAt(0);
//        new TabLayoutMediator(tabLayout,imageSliderView.viewPager,(tab, position) -> {
//
//        }).attach();
    }

    public DotIndicator(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
