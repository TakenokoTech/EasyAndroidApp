package tech.takenoko.easyandroidapp.model.localdb;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Inject;

import lombok.NonNull;
import tech.takenoko.easyandroidapp.App;

/**
 * Created by takenoko on 2018/04/28.
 */

public class BarcodeDBHelper extends SQLiteOpenHelper implements DatabaseConstance {

    private static BarcodeDBHelper inst;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Barcode.db";

    private BarcodeDBHelper() {
        super(App.getInstance().getApplicationContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    BarcodeDBHelper getInstance() {
        if(inst == null) {
            inst = new BarcodeDBHelper();
        }
        return inst;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // db.execSQL(SQL_DELETE_ENTRIES);
        // onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
