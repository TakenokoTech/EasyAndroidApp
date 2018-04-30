package tech.takenoko.easyandroidapp.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import tech.takenoko.easyandroidapp.App;

class BaseRepository {

    private Context context;

    BaseRepository(App app) {
        this.context = app.getApplicationContext();
    }
}
