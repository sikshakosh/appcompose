package com.android.appcompose.input;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Text extends TextView {
    public Text(Context context) {
        super(context);
    }

    public Text(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Text(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Text(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
