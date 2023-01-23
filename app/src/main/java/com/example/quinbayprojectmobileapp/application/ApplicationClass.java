package com.example.quinbayprojectmobileapp.application;

import android.app.Application;

import com.example.quinbayprojectmobileapp.constants.ConstantClass;
import com.example.quinbayprojectmobileapp.utils.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import okhttp3.OkHttpClient;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationClass extends Application {
    public Retrofit retrofit;
   @Override
    public void onCreate()
    {
        super.onCreate();

    }

    public  Retrofit getRetrofitClient(){
        if(retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .client(new OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(ConstantClass.BASE_URL).build();
        }
        return retrofit;
    }
}
