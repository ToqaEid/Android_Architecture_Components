package com.aboughalymotors.lifecyclearchitecturedemo.model.service;

import com.aboughalymotors.lifecyclearchitecturedemo.model.beans.GeneralResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Toqa on 11/7/2017.
 */

public interface Services {

    @GET("settings/minbookingdate")
    Call<GeneralResponse<String>> getMinBookingDate();

}
