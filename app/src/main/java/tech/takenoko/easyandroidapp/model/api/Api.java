package tech.takenoko.easyandroidapp.model.api;

import javax.inject.Inject;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.takenoko.easyandroidapp.App;
import tech.takenoko.easyandroidapp.utility.CLog;

/**
 * Created by takenoko on 2018/04/29.
 */

public class Api extends BaseApi {

    public interface ApiCallback {
        void success(ApiModel model);
        void failure();
    }

    @Inject
    Api(App app) {
        super(app);
    }

    public void getLetest(final ApiCallback callback) {
        ApiProtocol protocol = retrofit( "http://data.fixer.io/api/").create(ApiProtocol.class);
        Call<ApiModel> task =  protocol.latest("acc2a6ce4dc7780a217a73f40a8475e9");
        task.enqueue(new Callback<ApiModel>() {
            @Override
            public void onResponse(Call<ApiModel> call, Response<ApiModel> response) {
                if(response.isSuccessful()) {
                    CLog.info("API", response.body().toString());
                    callback.success(response.body());
                } else {
                    callback.failure();
                }
            }

            @Override
            public void onFailure(Call<ApiModel> call, Throwable t) {
                callback.failure();
            }
        });
    }
}
