package com.example.quinbayprojectmobileapp.application;

import android.app.Application;

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
        retrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(new OkHttpClient())
                .build();
    }
}
