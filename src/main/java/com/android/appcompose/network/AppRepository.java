package com.android.appcompose.network;

import android.app.Application;
import android.os.Build;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.appcompose.database.dao.MentorDao;
import com.android.appcompose.database.model.ClassroomModel;
import com.android.appcompose.database.dao.ClassroomDao;
import com.android.appcompose.database.WCRoomDatabase;
import com.android.appcompose.database.model.MentorModel;
import com.android.appcompose.network.model.Classroom;
import com.android.appcompose.network.model.ClassroomResponse;
import com.android.appcompose.network.model.Mentor;
import com.android.appcompose.network.model.MentorResponse;
import com.android.appcompose.utils.Utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {
    private final String TAG = "AppRepository";
    private static  AppRepository appRepository;
    private AppApi appApi;

    private ClassroomDao classroomDao;
    private MentorDao mentorDao;

    private LiveData<List<ClassroomModel>> mAllClassrooms;
    private LiveData<List<MentorModel>> mAllMentors;

    public static  AppRepository getInstance(Application application){
        if(appRepository==null){
            appRepository = new AppRepository(application   );
        }
        return appRepository;
    }

    public AppRepository(Application application){
        appApi = AppNetworkService.cteateService(AppApi.class);
        WCRoomDatabase db = WCRoomDatabase.getDatabase(application);
        classroomDao = db.getClassroomDao();
        mentorDao = db.getMentorDao();


    }
    //Database Calls
    public void saveClassroomModel(ClassroomModel um){
        WCRoomDatabase.databaseWriteExecutor.execute(()->{
            classroomDao.insert(um);
        });
    }

    public void saveMentorModel(MentorModel mm){
        WCRoomDatabase.databaseWriteExecutor.execute(()->{
            mentorDao.insert(mm);
        });
    }


    public LiveData<List<ClassroomModel>> getLocalClassrooms(){
       // classroomDao.deleteAll();
//        WCRoomDatabase.databaseWriteExecutor.execute(()->{
//            classroomDao.deleteAll();
//        });
        mAllClassrooms = classroomDao.getAllClassrooms();
       return mAllClassrooms;
    }

    public LiveData<List<MentorModel>> getLocalMentors(){

       // mentorDao.deleteAll();
//        WCRoomDatabase.databaseWriteExecutor.execute(()->{
//            mentorDao.deleteAll();
//        });
        mAllMentors = mentorDao.getAllMentors();
        return mAllMentors;
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
                        String hash = obj.getChash();
                        String[] arr = hash.split("-");
                        String[] nameArr = Arrays.copyOf(arr, arr.length-1);
                        String membersStr = obj.getMembers();
                        String admin = "";
                        try {
                            JSONArray jsonArr = new JSONArray(membersStr);
                            JSONObject adminObj = jsonArr.getJSONObject(0);
                            String uhash  = adminObj.getString("uhash");
                            String[] arr1 = uhash.split("-");
                            String[] arrName = Arrays.copyOf(arr1, arr1.length-1);
                           admin = Utilities.strJoin(arrName," ");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        ClassroomModel uc = new ClassroomModel();
                        uc.setId(obj.getId());
                        uc.setChash(obj.getChash());
                        uc.setName(Utilities.strJoin(nameArr," "));
                        uc.setAdmin(admin);
                        uc.setData(obj.getData());
                        uc.setMembers(obj.getMembers());
                        saveClassroomModel(uc);
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

    public void getRemoteMentors(){
        MutableLiveData<MentorResponse> featuredData = new MutableLiveData<>();
        appApi.listFeaturedMentors().enqueue(new Callback<MentorResponse>() {
            @Override
            public void onResponse(Call<MentorResponse> call, Response<MentorResponse> response) {
                Log.d(TAG,"onResponse called");
                if(response.isSuccessful()){
                    Log.d(TAG,"onResponse called is success");
                    MentorResponse result = response.body();
                    List<Mentor> list = result.getData();
                    int index = 1;
                    for (Mentor obj: list) {
                        String hash = obj.getUhash();
                        String[] arr = hash.split("-");
                        String[] nameArr = Arrays.copyOf(arr, arr.length-1);

                        MentorModel mm = new MentorModel    ();

                        mm.setId(index);
                        mm.setUhash(obj.getUhash());
                        mm.setImage(obj.getImage());
                        mm.setMimeType(obj.getMimeType());
                        mm.setName(obj.getName());

                        saveMentorModel(mm);
                        index++;
                    }


                }
            }

            @Override
            public void onFailure(Call<MentorResponse> call, Throwable t) {
                Log.d(TAG,"OnFailure called");
                featuredData.setValue(null);
            }
        });

    }


}
