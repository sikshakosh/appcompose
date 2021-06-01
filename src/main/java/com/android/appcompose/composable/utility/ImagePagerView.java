package com.android.appcompose.composable.utility;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.android.appcompose.R;

import java.lang.ref.Reference;

public class ImagePagerView extends LinearLayout {
    private ViewPager2 viewPager;
    private static final int NUM_PAGES = 5;
    private FragmentStateAdapter pagerAdapter;
    //public int[] drawables = {R.drawable.splash_1,R.drawable.splash_2,R.drawable.splash_3};
    public int[] drawables = {R.drawable.splash_1,R.drawable.splash_2,R.drawable.splash_3};
    public ImagePagerView(Context context, AttributeSet attrs){
        super(context,attrs);
       /* TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ImagePagerView);
        try
        {
//            Reference[] entries = (Reference[]) a.getTextArray(R.styleable.ImagePagerView_android_images);
//            if (entries != null)
//            {
//                //do something with the array if you want
//            }

          //  Reference entry1 = (Reference) a.getTextArray(R.styleable.ImagePagerView_splash_1);


        }
        finally
        {
            a.recycle();
        }*/
//        
//        a.recycle();
        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER_VERTICAL);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_image_pager, this, true);

        viewPager = (ViewPager2) getChildAt(0);
        viewPager.setPageTransformer(new ImageZoomOutPageTransformer());
        viewPager.setAdapter(new ScreenSlidePagerAdapter((FragmentActivity) context,drawables));
    }

    public ImagePagerView(Context context){
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
        public ImagePageFragment createFragment(int position) {
            return  ImagePageFragment.newInstance(position, listDrawables[position]);
        }

        @Override
        public int getItemCount() {
            return listDrawables.length;
        }
    }


}
