package com.fedor.pavel.greendaoexample.data.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pavel on 26.11.2016.
 */

public class SensuyakiTestService {

    private SensuyakiTestApi mApi;
    public static final String BASE_URL = "http://www.sensuyaki.com/";

    private SensuyakiTestService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        mApi = restAdapter.create(SensuyakiTestApi.class);
    }

    public static SensuyakiTestService newInstance() {
        return new SensuyakiTestService();
    }

    public SensuyakiTestApi getApi() {
        return mApi;
    }

}
