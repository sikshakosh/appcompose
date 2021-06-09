package com.android.appcompose.composable.utility.Slider.Pager;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.android.appcompose.R;

public class ImageSliderView extends LinearLayout {
    private ViewPager2 viewPager;
    private Integer transition;
    private static final int NUM_PAGES = 5;
    private FragmentStateAdapter pagerAdapter;
    //public int[] drawables = {R.drawable.splash_1,R.drawable.splash_2,R.drawable.splash_3};
    private int[] drawables;
    public ImageSliderView(Context context, AttributeSet attrs){
        super(context,attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ImagePagerView);
        try
        {

            int arrayResourceId = a.getResourceId(R.styleable.ImagePagerView_images, 0);
            transition = a.getInteger(R.styleable.ImagePagerView_transformer, 0);
            if (arrayResourceId != 0) {
                final TypedArray resourceArray = getResources().obtainTypedArray(arrayResourceId);
                drawables = new int[resourceArray.length()];
                for (int i = 0; i < resourceArray.length(); i++) {
                    final int resourceId = resourceArray.getResourceId(i, 0);
                    drawables[i] = resourceId;
                    // do stuff with resourceId, such as getResources().getDrawable(resourceId)
                }
                resourceArray.recycle();
            }


            Log.d("STYLABLE","hello");

        }
        finally
        {
            a.recycle();
        }

        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER_VERTICAL);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_image_pager, this, true);

        viewPager = (ViewPager2) getChildAt(0);
        if(transition==1){
            viewPager.setPageTransformer(new ImageSliderZoomOutPageTransformer());
        }

        viewPager.setAdapter(new ScreenSlidePagerAdapter((FragmentActivity) context,drawables));
    }

    public ImageSliderView(Context context){
        this(context,null);
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        //private ArrayList<Integer> IMAGES = {R.drawable.background,R.drawable.background,R.drawable.background,R.drawable.background};

        private int[] listDrawables;
        public ScreenSlidePagerAdapter(FragmentActivity fa, int[] drawables) {
            super(fa);
            listDrawables = drawables;
        }

        @Override
        public ImageSliderFragment createFragment(int position) {
            return  ImageSliderFragment.newInstance(position, listDrawables[position]);
        }

        @Override
        public int getItemCount() {
            return listDrawables.length;
        }
    }


}
