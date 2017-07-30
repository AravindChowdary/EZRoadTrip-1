package easyroadtrip.com.ezroadtrip.Data.datasource.hereapi;

import java.util.List;

import easyroadtrip.com.ezroadtrip.Data.entity.PlaceResultEntity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Dora on 7/30/2017.
 */

public interface HereApi {

    @GET("/places/v1/autosuggest?&at=52.5304417,13.4111201")
    Call<PlaceResultEntity> requestSuggestedPlaces(
            @Query("q") String query
    );


}
