package com.android.appcompose.network;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {
    private final String TAG = "AppRepository";
    private static  AppRepository appRepository;
    private AppApi appApi;

    public static  AppRepository getInstance(){
        if(appRepository==null){
            appRepository = new AppRepository();
        }
        return appRepository;
    }

    public AppRepository(){
        appApi = AppNetworkService.cteateService(AppApi.class);
    }

    public MutableLiveData<ClassroomResponse> getFeaturedClassrooms(){
        MutableLiveData<ClassroomResponse> featuredData = new MutableLiveData<>();
        appApi.listFeaturedClassroom().enqueue(new Callback<ClassroomResponse>() {
            @Override
            public void onResponse(Call<ClassroomResponse> call, Response<ClassroomResponse> response) {
                Log.d(TAG,"onResponse called");
                if(response.isSuccessful()){
                    Log.d(TAG,"onResponse called is success");
                    featuredData.setValue((ClassroomResponse) response.body());
                }
            }

            @Override
            public void onFailure(Call<ClassroomResponse> call, Throwable t) {
                Log.d(TAG,"OnFailure called");
                featuredData.setValue(null);
            }
        });
        return featuredData;
    }
}
