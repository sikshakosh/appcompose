package com.android.appcompose.network;

import com.android.appcompose.network.model.ClassroomResponse;
import com.android.appcompose.network.model.MentorResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AppApi {

    @GET("/apps/overview/featured/classrooms")
    Call<ClassroomResponse> listFeaturedClassroom();

    @GET("/apps/overview/featured/mentors")
    Call<MentorResponse> listFeaturedMentors();
}
