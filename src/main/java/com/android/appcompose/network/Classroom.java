package com.android.appcompose.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Classroom {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("chash")
    @Expose
    private String chash;

    @SerializedName("ascii_code")
    @Expose
    private String ascii_code;

    @SerializedName("word_count")
    @Expose
    private String word_count;

    @SerializedName("user")
    @Expose
    private String user;

    @SerializedName("data")
    @Expose
    private String data;

    @SerializedName("members")
    @Expose
    private String members;

    @SerializedName("invites")
    @Expose
    private String invites;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChash() {
        return chash;
    }

    public void setChash(String chash) {
        this.chash = chash;
    }

    public String getAscii_code() {
        return ascii_code;
    }

    public void setAscii_code(String ascii_code) {
        this.ascii_code = ascii_code;
    }

    public String getWord_count() {
        return word_count;
    }

    public void setWord_count(String word_count) {
        this.word_count = word_count;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getInvites() {
        return invites;
    }

    public void setInvites(String invites) {
        this.invites = invites;
    }
}
