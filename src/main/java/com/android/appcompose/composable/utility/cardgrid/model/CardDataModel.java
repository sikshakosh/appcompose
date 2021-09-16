package com.android.appcompose.composable.utility.cardgrid.model;

import com.android.appcompose.utils.DataType;

public class CardDataModel{

    public String title, subtitle;
    public DataType type;
    public int index;
    public CardDataModel(int index,String title, String subtitle, DataType type) {
        this.index = index;
        this.title = title;
        this.subtitle = subtitle;
        this.type = type;
    }
}