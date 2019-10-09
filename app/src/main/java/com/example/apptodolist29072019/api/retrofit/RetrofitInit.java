package com.example.apptodolist29072019.api.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;

public class RetrofitInit {
    //1: Khoi tao Retrofit
    //2: Khoi tao ra lop interface Request
    //3: Tra ve kieu du lieu chinh lop interface request
    //4: Khong cho nguoi khac co quyen khoi tao ra lop nay

    private static Retrofit retrofit = null;

    private RetrofitInit() {

    }
    // nguoi dung goi phuong thuc nay se khoi tao 2 class tren va tra ve

    public static APIRequest initApi() {
        if (retrofit == null) {
            retrofit = getInstance();
        }
        return retrofit.create(APIRequest.class);
    }

    private static Retrofit getInstance() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .disableHtmlEscaping()
                .create();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();
    }
}
