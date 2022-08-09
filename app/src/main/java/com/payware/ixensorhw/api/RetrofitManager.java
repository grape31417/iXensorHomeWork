package com.payware.ixensorhw.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Description :
 *
 * @author 498g0
 * @date 2022/8/9
 */
public class RetrofitManager {

    private static Retrofit retrofit = null;
    private static final String baseUrl="https://inner.ixensor.com/InterviewAPI/android/";
    public static final int STATUS_SUCCESS= 0;

    public static APIService getRetrofitClient() {


        if (retrofit==null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(APIService.class);
    }

}
