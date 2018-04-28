package tech.takenoko.easyandroidapp;

import android.app.Application;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;


/**
 * Created by takenoko on 2018/04/28.
 */

public class App extends DaggerApplication {

    private static App inst;

    @Override
    public void onCreate() {
        super.onCreate();
        inst = this;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }

    public static App getInstance() {
        return inst;
    }
}
