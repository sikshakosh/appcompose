package com.android.appcompose.network;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AppNetworkService {
    private AppApi appService;
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://wideclassrooms.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S cteateService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
