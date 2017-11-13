package com.aboughalymotors.lifecyclearchitecturedemo.observers;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

/**
 * Created by Toqa on 11/13/2017.
 */

public class SecondObserver implements LifecycleObserver {

    public static final String TAG = "main";


    public SecondObserver(LifecycleOwner lifeCycleOwner) {
        lifeCycleOwner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        Log.d(TAG, "SecondObserver: onCreate: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
        Log.d(TAG, "SecondObserver: onStop: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart() {
        Log.d(TAG, "SecondObserver: onStart: ");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        Log.d(TAG, "SecondObserver: onDestroy: ");
    }
}
