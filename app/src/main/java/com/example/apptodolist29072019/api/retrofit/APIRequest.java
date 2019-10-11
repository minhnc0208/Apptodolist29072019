package com.example.apptodolist29072019.api.retrofit;

import com.example.apptodolist29072019.api.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIRequest {
    @FormUrlEncoded
    @POST("register.php")
    Call<LoginResponse> onLoginResult(@Field("username") String username,
                                      @Field("Password") String password);

}
