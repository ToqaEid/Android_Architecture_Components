package com.aboughalymotors.lifecyclearchitecturedemo.observers;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by Toqa on 11/12/2017.
 */

public class MainObserver implements LifecycleObserver, LifecycleOwner {

    private LifecycleRegistry mLifecycleRegistry;
    public static final String TAG = "main";


    public MainObserver(LifecycleOwner lifeCycleOwner) {
        lifeCycleOwner.getLifecycle().addObserver(this);

        mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry.addObserver(new SecondObserver(this));
        mLifecycleRegistry.addObserver(new ThirdObserver(this));

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        Log.d(TAG, "MainObserver: onCreate: ");
        mLifecycleRegistry.markState(Lifecycle.State.CREATED);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
        Log.d(TAG, "MainObserver: onStop: ");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart() {
        Log.d(TAG, "MainObserver: onStart: ");
        mLifecycleRegistry.markState(Lifecycle.State.STARTED);

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        Log.d(TAG, "MainObserver: onDestroy: ");
        mLifecycleRegistry.markState(Lifecycle.State.DESTROYED);

    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }
}
