package com.aboughalymotors.lifecyclearchitecturedemo;

import android.app.Application;

/**
 * Created by Toqa on 11/9/2017.
 */

public class App extends Application {

    ////VARIABLES
    private static App app;

    ////METHODS
    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
    }

    public static App getInstance(){
        return app;
    }
}
