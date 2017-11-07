package com.aboughalymotors.lifecyclearchitecturedemo.model.service;

import retrofit2.Retrofit;

public class ServiceGenerator {

    // Create Service
    public static <T> T createBaseService(String baseURL, Class<T> serviceClass) {
        Retrofit retrofit = NetworkBuilder.getNetworkBuilder(baseURL);
        return retrofit.create(serviceClass);
    }


    // Create Service
    public static Services createService() {
        return createBaseService(NetworkBuilder.URL_BASE, Services.class);
    }


}
