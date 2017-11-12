package com.aboughalymotors.lifecyclearchitecturedemo.model.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.util.Log;

import com.aboughalymotors.lifecyclearchitecturedemo.App;
import com.aboughalymotors.lifecyclearchitecturedemo.model.beans.GeneralResponse;
import com.aboughalymotors.lifecyclearchitecturedemo.model.storage.AppDataBase;
import com.aboughalymotors.lifecyclearchitecturedemo.model.storage.MinDateTimeEntity;
import com.aboughalymotors.lifecyclearchitecturedemo.model.storage.SharedPreferenceHandler;
import com.aboughalymotors.lifecyclearchitecturedemo.model.service.ServiceGenerator;
import com.aboughalymotors.lifecyclearchitecturedemo.model.service.Services;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Toqa on 11/7/2017.
 */

public class MinDateTimeRepository {

    ////VARIABLES
    private Services webService;
    private SharedPreferenceHandler handler;

    ////METHODS
    //Constructor
    public MinDateTimeRepository() {
        webService = ServiceGenerator.createService();
    }

    //Public Methods
    public LiveData<String> getMinDateTime(){

        final MutableLiveData<String> data = new MutableLiveData<>();

        final AppDataBase db = Room.databaseBuilder(App.getInstance().getApplicationContext(),
                AppDataBase.class, "db").allowMainThreadQueries().build();

        List<String> minDate = db.minDateTimeDao().getMinDateTime();

        if (minDate != null && minDate.size() > 0){ //DB

            getDataFromDB(data, minDate);

        }else { //Webservice

            getDataFromWebService(db, data);

        }

        return data;
    }

    /*================================== PRIVATE HELPFUL METHODS ==============================*/
    private void getDataFromDB(MutableLiveData<String> data, List<String> minDate) {
        data.setValue(minDate.get(0));
        Log.d("main", "getMinDateTime: (minDate.get(0): " + (minDate.get(0)));
    }

    private void getDataFromWebService(final AppDataBase db, final MutableLiveData<String> data) {

        Call<GeneralResponse<String>> call = webService.getMinBookingDate();
        call.enqueue(new Callback<GeneralResponse<String>>() {
            @Override
            public void onResponse(Call<GeneralResponse<String>> call, Response<GeneralResponse<String>> response) {
                Log.d("main", "onResponse: response.body().getModel(): " + response.body().getModel());
                data.setValue(response.body().getModel());
                db.minDateTimeDao().insertDate(new MinDateTimeEntity(response.body().getModel()));
            }

            @Override
            public void onFailure(Call<GeneralResponse<String>> call, Throwable t) {

            }
        });

    }
}
