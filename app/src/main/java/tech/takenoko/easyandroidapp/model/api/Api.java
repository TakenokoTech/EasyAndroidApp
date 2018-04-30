package tech.takenoko.easyandroidapp.model.api;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import tech.takenoko.easyandroidapp.App;
import tech.takenoko.easyandroidapp.model.api.io.ApiHandler;
import tech.takenoko.easyandroidapp.model.api.io.NetworkCallback;
import tech.takenoko.easyandroidapp.model.api.model.ApiModel;
import tech.takenoko.easyandroidapp.model.api.protocol.ApiProtocol;

/**
 * Created by takenoko on 2018/04/29.
 */
@Singleton
public class Api extends BaseApi {

    private final String tag = this.toString();

    @Inject
    Api(App app) {
        super(app);
    }

    public void getLetest(final ApiHandler<ApiModel> callback) {
        Call<ApiModel> task = retrofit( "http://data.fixer.io/api/", ApiProtocol.class).latest("acc2a6ce4dc7780a217a73f40a8475e9");
        task.enqueue(new NetworkCallback<ApiModel>(callback));
    }
}
