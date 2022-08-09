package com.payware.ixensorhw.api;

import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Description :
 *
 * @author 498g0
 * @date 2022/8/9
 */
public interface  APIService {

    @POST("interview.php?api=register")
    Call<RespondAPI> register (@Body RequestBody body);

    @POST("interview.php?api=login")
    Call<RespondAPI> login (@Body RequestBody body);

    @GET("interview.php?api=get_user_info&token=")
    Call<UserInfoAPI> getUserInfo (@Query("token") String token);


}
