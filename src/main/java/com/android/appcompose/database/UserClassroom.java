package com.android.appcompose.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.math.BigInteger;

@Entity(tableName = "user_classroom")
public class UserClassroom {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "hash")
    private String chash;

    @NonNull
    @ColumnInfo(name = "admin")
    private String admin;

    @NonNull
    @ColumnInfo(name = "data")
    private String data;

    @NonNull
    @ColumnInfo(name = "members ")
    private String members;


    @ColumnInfo(name = "invites")
    private String invites;

    @ColumnInfo(name = "featured")
    private Boolean featured;

    @ColumnInfo(name = "created_timestamp")
    private Integer createdTimestamp;

    @ColumnInfo(name = "sync_timestamp")
    private Integer syncTimestamp;

    public UserClassroom(@NonNull Integer id, @NonNull String name, @NonNull String chash, @NonNull String admin, @NonNull String data, @NonNull String members, String invites, Boolean featured, Integer createdTimestamp, Integer syncTimestamp) {
        this.id = id;
        this.name = name;
        this.chash = chash;
        this.admin = admin;
        this.data = data;
        this.members = members;
        this.invites = invites;
        this.featured = featured;
        this.createdTimestamp = createdTimestamp;
        this.syncTimestamp = syncTimestamp;
    }

    public UserClassroom() {
    }


    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getChash() {
        return chash;
    }

    public void setChash(@NonNull String chash) {
        this.chash = chash;
    }

    @NonNull
    public String getAdmin() {
        return admin;
    }

    public void setAdmin(@NonNull String admin) {
        this.admin = admin;
    }

    @NonNull
    public String getData() {
        return data;
    }

    public void setData(@NonNull String data) {
        this.data = data;
    }

    @NonNull
    public String getMembers() {
        return members;
    }

    public void setMembers(@NonNull String members) {
        this.members = members;
    }

    public String getInvites() {
        return invites;
    }

    public void setInvites(String invites) {
        this.invites = invites;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public Integer getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Integer createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Integer getSyncTimestamp() {
        return syncTimestamp;
    }

    public void setSyncTimestamp(Integer syncTimestamp) {
        this.syncTimestamp = syncTimestamp;
    }
}
