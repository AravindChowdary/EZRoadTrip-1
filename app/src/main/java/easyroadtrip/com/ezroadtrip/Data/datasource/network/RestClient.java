package easyroadtrip.com.ezroadtrip.Data.datasource.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dora on 7/24/2017.
 */

public class RestClient {

    private static String END_POINT = "https://ezroad.mybluemix.net";
    public static RestApi restApi;

    static {
        setupRestClient();
    }

    public static void setupRestClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(2, TimeUnit.MINUTES);
        okHttpClient.readTimeout(2, TimeUnit.MINUTES);
        okHttpClient.addInterceptor(logging);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(END_POINT)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.client(okHttpClient.build()).build();

        restApi = retrofit.create(RestApi.class);
    }

}
