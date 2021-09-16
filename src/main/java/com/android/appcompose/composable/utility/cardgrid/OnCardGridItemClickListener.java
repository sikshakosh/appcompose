package com.android.appcompose.composable.utility.cardgrid;

import com.android.appcompose.utils.DataType;

public interface OnCardGridItemClickListener{
    void onCategoryClicked(DataType category);
    void onItemClicked(Object item);
}