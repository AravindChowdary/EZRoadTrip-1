package easyroadtrip.com.ezroadtrip.Data.datasource.hereapi;

import java.io.IOException;

import easyroadtrip.com.ezroadtrip.Presentation.application.EZApplication;
import easyroadtrip.com.ezroadtrip.R;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dora on 7/30/2017.
 */

public class HereApiClient {


    final static String appId = EZApplication.getContext().getResources().getString(R.string.app_id);
    final static String appCode = EZApplication.getContext().getResources().getString(R.string.app_code);

    public static HereApi placeApi() {
        HereApi hereApi = null;
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        //okHttpClient.addInterceptor(logging);
        okHttpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("app_id", appId)
                        .addQueryParameter("app_code", appCode)
                        .build();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://places.cit.api.here.com")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit  = builder.client(okHttpClient.build()).build();

        hereApi = retrofit.create(HereApi.class);

        return hereApi;
    }

}
