package com.aboughalymotors.lifecyclearchitecturedemo;

import android.app.Application;

/**
 * Created by Toqa on 11/9/2017.
 */

public class App extends Application {

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();

//        RoomDB.getInstance(this); //This will provide AppDatabase Instance

        app = this;
    }

    public static App getInstance(){
        return app;
    }
}
