package tech.takenoko.easyandroidapp.presenter;

import android.content.Context;

import tech.takenoko.easyandroidapp.App;
import tech.takenoko.easyandroidapp.view.io.MainViewable;

/**
 * Created by takenoko on 2018/04/28.
 */

abstract class BasePresenter {

    private Context context;

    BasePresenter(App app) {
        this.context = app.getApplicationContext();
    }
    
    void loadView() {

    }
}
