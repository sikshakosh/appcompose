package com.android.appcompose.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AppApi {

    @GET("/apps/overview/featured/classrooms")
    Call<ClassroomResponse> listFeaturedClassroom();

    @GET("/apps/overview/featured/members")
    Call<ClassroomResponse> listFeaturedMembers();
}
