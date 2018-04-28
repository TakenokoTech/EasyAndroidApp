package tech.takenoko.easyandroidapp.utility;

import android.util.Log;

import lombok.NonNull;
import lombok.val;

/**
 * Created by takenoko on 2018/04/28.
 */

public class CLog {

    final static String LOG_FORMAT = "--- [ %-30s ]%s";

    private String isCurrent() {
        return ""; // Thread.currentThread().equals(getMainLooper().getThread());
    }

    void debug(@NonNull String tag, @NonNull String msg) {
        Log.d(String.format(LOG_FORMAT, tag, isCurrent()), msg);
    }

    void info(@NonNull String tag, @NonNull String msg) {
        Log.i(String.format(LOG_FORMAT, tag, isCurrent()), msg);
    }

    void warn(@NonNull String tag, @NonNull String msg) {
        Log.w(String.format(LOG_FORMAT, tag, isCurrent()), msg);
    }

    void error(@NonNull String tag, @NonNull String msg) {
        Log.e(String.format(LOG_FORMAT, tag, isCurrent()), msg);
    }
}
