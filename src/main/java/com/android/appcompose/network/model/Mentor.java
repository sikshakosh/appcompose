package com.android.appcompose.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mentor {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("uid")
    @Expose
    private String uid;

    @SerializedName("uhash")
    @Expose
    private String uhash;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("mimeType")
    @Expose
    private String mimeType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUhash() {
        return uhash;
    }

    public void setUhash(String uhash) {
        this.uhash = uhash;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
