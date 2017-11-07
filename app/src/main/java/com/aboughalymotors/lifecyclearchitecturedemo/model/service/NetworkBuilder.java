package com.aboughalymotors.lifecyclearchitecturedemo.model.service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by m.nabil on 3/21/2016.
 */
public class NetworkBuilder {

    private static Retrofit retrofit;

    public static final String URL_BASE = "http://65.182.108.16:5080/api/v1.0/"; //TEST
    public static final int TIME_OUT_IN_SECONDS = 15;



    // Get Network Builder
    public static Retrofit getNetworkBuilder() {
        return getNetworkBuilder(URL_BASE);
    }

    public static Retrofit getNetworkBuilder(String baseURL) {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(TIME_OUT_IN_SECONDS, TimeUnit.SECONDS)
                    .readTimeout(TIME_OUT_IN_SECONDS, TimeUnit.SECONDS)
                    .writeTimeout(TIME_OUT_IN_SECONDS, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }

        return retrofit;
    }

}
