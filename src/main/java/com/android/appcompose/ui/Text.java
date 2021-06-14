package com.android.appcompose.ui;

import android.content.Context;
import android.util.AttributeSet;


import androidx.annotation.NonNull;
import  androidx.appcompat.widget.AppCompatTextView;


import androidx.annotation.Nullable;

public class Text extends AppCompatTextView {

    public Text(@NonNull Context context) {
        super(context);
    }

    public Text(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Text(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
