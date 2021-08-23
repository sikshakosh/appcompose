package com.android.appcompose.composable.utility.cardgrid.model;

import com.android.appcompose.utils.DataType;

import java.util.ArrayList;

public class ParentModel {
    private String itemCategory;
    private ArrayList<Object> data;
    private DataType type;


    public ParentModel(DataType type) {
        this.itemCategory = type.getCaption();
        this.type = type;
        data = new ArrayList<Object>();

    }


    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public ArrayList<Object> getData() {
        return data;
    }

    public void setData(ArrayList<Object> data) {
        this.data = data;
    }

    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }
}
