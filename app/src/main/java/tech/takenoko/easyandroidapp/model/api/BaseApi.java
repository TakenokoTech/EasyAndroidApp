package tech.takenoko.easyandroidapp.model.api;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.takenoko.easyandroidapp.App;

/**
 * Created by takenoko on 2018/04/29.
 */

class BaseApi {

    private static Context context;

    BaseApi(App app) {
        context = app.getApplicationContext();
    }

    static <T> T retrofit(String url, Class<T> protocolClass) {
        Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl(url)
                                        .client(new OkHttpClient())
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build();
        return retrofit.create(protocolClass);
    }
}
