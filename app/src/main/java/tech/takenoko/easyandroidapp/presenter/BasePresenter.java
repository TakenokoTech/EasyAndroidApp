package tech.takenoko.easyandroidapp.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.UiThread;

import tech.takenoko.easyandroidapp.App;
import tech.takenoko.easyandroidapp.view.io.MainViewable;

/**
 * Created by takenoko on 2018/04/28.
 */

abstract class BasePresenter {

    protected Context context;
    private Handler uiThreadHandler;

    BasePresenter(App app) {
        this.context = app.getApplicationContext();
        uiThreadHandler = new Handler(Looper.getMainLooper());
    }

    void uiThread(Runnable runnable) {
        uiThreadHandler.post(runnable);
    }
    
    void loadView() {

    }
}
