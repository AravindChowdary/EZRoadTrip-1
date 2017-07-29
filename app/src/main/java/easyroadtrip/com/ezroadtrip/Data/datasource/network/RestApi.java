package easyroadtrip.com.ezroadtrip.Data.datasource.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Dora on 7/24/2017.
 */

public interface RestApi {

    @GET("/apis/v1/roles")
    Call<String> requestUserRepo(@Query("idprolemap") String idRoadMap);

}
