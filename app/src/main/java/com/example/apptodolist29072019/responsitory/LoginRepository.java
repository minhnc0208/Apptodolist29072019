package com.example.apptodolist29072019.responsitory;

import androidx.lifecycle.MutableLiveData;

import com.example.apptodolist29072019.api.response.LoginResponse;
import com.example.apptodolist29072019.api.retrofit.APIRequest;
import com.example.apptodolist29072019.api.retrofit.RetrofitInit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {

    private static LoginRepository repository = null;
    private APIRequest apiRequest;

    public LoginRepository() {
        apiRequest = RetrofitInit.initApi();
    }

    public static LoginRepository getInstance() {
        if (repository == null) {
            repository = new LoginRepository();
        }
        return repository;
    }

    final MutableLiveData<LoginResponse> loginResponse = new MutableLiveData<>();

    public MutableLiveData<LoginResponse> checkLogin(String username, String password) {
        final MutableLiveData<LoginResponse> loginResponseMutableLiveData = new MutableLiveData<>();
        apiRequest.onLoginResult(username, password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                loginResponse.postValue(response.body());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
        return loginResponse;
    }
}
