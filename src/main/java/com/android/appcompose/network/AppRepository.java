package com.android.appcompose.network;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.appcompose.database.UserClassroom;
import com.android.appcompose.database.UserClassroomDao;
import com.android.appcompose.database.WCRoomDatabase;
import com.android.appcompose.network.model.Classroom;
import com.android.appcompose.network.model.ClassroomResponse;
import com.android.appcompose.network.model.MentorResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {
    private final String TAG = "AppRepository";
    private static  AppRepository appRepository;
    private AppApi appApi;

    private UserClassroomDao userClassroomDao;

    private LiveData<List<UserClassroom>> mAllClassrooms;
    public static  AppRepository getInstance(Application application){
        if(appRepository==null){
            appRepository = new AppRepository(application   );

        }
        return appRepository;
    }

    public AppRepository(Application application){
        appApi = AppNetworkService.cteateService(AppApi.class);
        WCRoomDatabase db = WCRoomDatabase.getDatabase(application);
        userClassroomDao = db.userClassroomDao();

    }
    //Database Calls
    public void saveUserClassroom(UserClassroom uc){
        WCRoomDatabase.databaseWriteExecutor.execute(()->{
            userClassroomDao.insert(uc);
        });
    }

    public LiveData<List<UserClassroom>> getLocalClassrooms(){
        mAllClassrooms = userClassroomDao.getAllClassrooms();
       return mAllClassrooms;
    }

    // Network Calls
    public void getRemoteClassrooms(){
        MutableLiveData<ClassroomResponse> featuredData = new MutableLiveData<>();
        appApi.listFeaturedClassroom().enqueue(new Callback<ClassroomResponse>() {
            @Override
            public void onResponse(Call<ClassroomResponse> call, Response<ClassroomResponse> response) {
                Log.d(TAG,"onResponse called");
                if(response.isSuccessful()){
                    Log.d(TAG,"onResponse called is success");
                    ClassroomResponse result = response.body();
                    List<Classroom> list = result.getData();
                    for (Classroom obj: list) {
                        UserClassroom uc = new UserClassroom();
                        uc.setId(obj.getId());
                        uc.setChash(obj.getChash());
                        uc.setName("test");
                        uc.setChash("test");
                        uc.setAdmin("test");
                        uc.setData("test");
                        uc.setMembers("test");
                        saveUserClassroom(uc);
                    }


                }
            }

            @Override
            public void onFailure(Call<ClassroomResponse> call, Throwable t) {
                Log.d(TAG,"OnFailure called");
                featuredData.setValue(null);
            }
        });

    }

    public MutableLiveData<MentorResponse> getFeaturedMentors(){
        MutableLiveData<MentorResponse> featuredData = new MutableLiveData<>();
        appApi.listFeaturedMentors().enqueue(new Callback<MentorResponse>() {
            @Override
            public void onResponse(Call<MentorResponse> call, Response<MentorResponse> response) {
                Log.d(TAG,"onResponse called");
                if(response.isSuccessful()){
                    Log.d(TAG,"onResponse called is success");
                    featuredData.setValue((MentorResponse) response.body());
                }
            }

            @Override
            public void onFailure(Call<MentorResponse> call, Throwable t) {
                Log.d(TAG,"OnFailure called");
                featuredData.setValue(null);
            }
        });
        return featuredData;
    }
}
