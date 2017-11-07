package com.aboughalymotors.lifecyclearchitecturedemo.model.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.aboughalymotors.lifecyclearchitecturedemo.model.beans.GeneralResponse;
import com.aboughalymotors.lifecyclearchitecturedemo.model.localstorage.SharedPreferenceHandler;
import com.aboughalymotors.lifecyclearchitecturedemo.model.service.ServiceGenerator;
import com.aboughalymotors.lifecyclearchitecturedemo.model.service.Services;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Toqa on 11/7/2017.
 */

public class MinDateTimeRepository {
    private Services webService;
    private SharedPreferenceHandler handler;

    public MinDateTimeRepository() {
        webService = ServiceGenerator.createService();
//        Call<GeneralResponse<String>> call = londonCabService.getMinBookingDate();
//        processCall(call, callback);
    }

    public LiveData<String> getMinDateTime(){
        final MutableLiveData<String> data = new MutableLiveData<>();

        Call<GeneralResponse<String>> call = webService.getMinBookingDate();
        call.enqueue(new Callback<GeneralResponse<String>>() {
            @Override
            public void onResponse(Call<GeneralResponse<String>> call, Response<GeneralResponse<String>> response) {
                Log.d("main", "onResponse: response.body().getModel(): " + response.body().getModel());
                data.setValue(response.body().getModel());
            }

            @Override
            public void onFailure(Call<GeneralResponse<String>> call, Throwable t) {

            }
        });

        return data;
    }
}
