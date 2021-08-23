package com.android.appcompose.utils;


public enum DataType {
    FEATURED_CLASSROOMS("Featured Classrooms"),
    FEATURED_MENTORS("Featured Mentors");

    private String caption;

    DataType(String caption){
        this.caption = caption;
    }

    public String getCaption(){
        return caption;
    }
}
