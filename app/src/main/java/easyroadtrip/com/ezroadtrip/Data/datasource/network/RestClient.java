package dora.edu.demoapplication.network.impl;

import dora.edu.demoapplication.network.RestApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dora on 7/24/2017.
 */

public class RestClient {

    private static String END_POINT = "https://api.github.com/";
    public static RestApi restApi;

    static {
        setupRestClient();
    }

    public static void setupRestClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(END_POINT)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.client(okHttpClient.build()).build();

        restApi = retrofit.create(RestApi.class);
    }

}
