package com.android.appcompose.composable.utility;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.android.appcompose.R;

public class ImagePagerView extends LinearLayout {
    private ViewPager2 viewPager;
    private static final int NUM_PAGES = 5;
    private FragmentStateAdapter pagerAdapter;

    public ImagePagerView(Context context, AttributeSet attrs){
        super(context,attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ImagePagerView);
//        Drawable tutorial1 = a.getDrawable(R.styleable.ImagePagerView_splash_1);
//        Drawable tutorial2 = a.getDrawable(R.styleable.ImagePagerView_splash_2);
//        Drawable tutorial3 = a.getDrawable(R.styleable.ImagePagerView_splash_3);
//        
        a.recycle();
        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER_VERTICAL);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        viewPager = (ViewPager2) getChildAt(0);
        viewPager.setPageTransformer(new ImageZoomOutPageTransformer());

    }

    public ImagePagerView(Context context){
        this(context,null);
    }


}
