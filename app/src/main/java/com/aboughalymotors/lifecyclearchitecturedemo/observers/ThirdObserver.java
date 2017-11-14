package com.aboughalymotors.lifecyclearchitecturedemo.observers;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

/**
 * Created by Toqa on 11/13/2017.
 */

public class ThirdObserver implements LifecycleObserver {

    public static final String TAG = "main";


    public ThirdObserver(LifecycleOwner lifeCycleOwner) {
        lifeCycleOwner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        Log.d(TAG, "ThirdObserver: onCreate: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
        Log.d(TAG, "ThirdObserver: onStop: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart() {
        Log.d(TAG, "ThirdObserver: onStart: ");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        Log.d(TAG, "ThirdObserver: onDestroy: ");
    }
}
