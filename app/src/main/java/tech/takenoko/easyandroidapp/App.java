package tech.takenoko.easyandroidapp;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;


/**
 * Created by takenoko on 2018/04/28.
 */

public class App extends DaggerApplication {

    private static App inst;
    private AppComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        inst = this;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        applicationComponent = DaggerAppComponent.builder().application(this).build();
        return applicationComponent;
    }

    public AppComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static App getInstance() {
        return inst;
    }
}
