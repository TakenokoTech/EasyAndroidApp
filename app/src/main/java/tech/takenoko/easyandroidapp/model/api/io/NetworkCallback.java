package tech.takenoko.easyandroidapp.model.api.io;


import android.support.annotation.NonNull;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tech.takenoko.easyandroidapp.model.api.io.ApiHandler;
import tech.takenoko.easyandroidapp.utility.ApiException;
import tech.takenoko.easyandroidapp.utility.CLog;

public class NetworkCallback<T> implements Callback<T> {

    private ApiHandler handler;

    public NetworkCallback(@NonNull ApiHandler handler) {
        this.handler = handler;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if(response != null && response.errorBody() != null) {
            try {
                if(response.code() >= 400) {
                    String errorBody = response.errorBody().string();
                    CLog.error("onResponse","error: " + errorBody + " code: " + response.code());
                    onFailure(call, new ApiException());
                    return;
                }
            } catch (IOException e) {
                CLog.error("onResponse.IOException","error: " + e.getMessage() + " code: " + response.code());
                onFailure(call, e);
                return;
            }
        }
        if(response.isSuccessful()) {
            CLog.info("API", response.body().toString());
            handler.success(response.body());
        } else {
            handler.failure();
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if  (t != null) {
            CLog.error("onFailure", "t: " + t.getCause());
        } else {
            CLog.error("onFailure", "Not access.");
        }
        handler.failure();
    }
}
