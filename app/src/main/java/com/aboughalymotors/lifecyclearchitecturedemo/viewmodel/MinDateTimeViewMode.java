package com.aboughalymotors.lifecyclearchitecturedemo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.aboughalymotors.lifecyclearchitecturedemo.model.repository.MinDateTimeRepository;

/**
 * Created by Toqa on 11/7/2017.
 */

public class MinDateTimeViewMode extends AndroidViewModel {

    MinDateTimeRepository repository;
    LiveData<String> data;

    public MinDateTimeViewMode(@NonNull Application application) {
        super(application);

    }

    public void init(){
        repository = new MinDateTimeRepository();
        data = repository.getMinDateTime();
    }
    public LiveData<String> getMinDate(){
        Log.d("main", "getMinDate: data: " + data);
        return data;
    }
}
