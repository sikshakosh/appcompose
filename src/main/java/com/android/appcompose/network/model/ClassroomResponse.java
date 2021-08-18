package com.android.appcompose.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClassroomResponse {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Classroom> data = null;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Classroom> getData() {
        return data;
    }

    public void setData(List<Classroom> data) {
        this.data = data;
    }
}
