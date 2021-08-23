package com.android.appcompose.composable.utility.cardgrid.model;

public class ChildModel {
    private String category;

    public ChildModel(String movieCategory) {
        this.category = movieCategory;
    }
    public String itemCategory() {
        return category;
    }
}
