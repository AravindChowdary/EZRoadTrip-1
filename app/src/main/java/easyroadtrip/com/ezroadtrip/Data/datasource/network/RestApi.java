package easyroadtrip.com.ezroadtrip.Data.datasource.network;

import java.util.List;

import easyroadtrip.com.ezroadtrip.Data.entity.SuggestedPlace;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Dora on 7/24/2017.
 */

public interface RestApi {

    @GET("/apis/places/{startLat}/{startLon}/{desLat}/{desLon}")
    Call<List<SuggestedPlace>> requestSuggestedRoute(
        @Path("startLat") double startLat,
        @Path("startLon") double startLon,
        @Path("desLat") double desLat,
        @Path("desLon") double desLon
    );

}