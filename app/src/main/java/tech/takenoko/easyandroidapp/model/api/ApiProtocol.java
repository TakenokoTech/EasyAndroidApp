package tech.takenoko.easyandroidapp.model.api;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by takenoko on 2018/04/29.
 */

public interface ApiProtocol {

    @GET("latest")
    Call<ApiModel> latest(
            @Query("access_key") String accessKey
    );
}
