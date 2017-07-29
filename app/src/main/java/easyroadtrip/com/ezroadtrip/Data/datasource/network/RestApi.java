package dora.edu.demoapplication.network;

import java.util.List;

import dora.edu.demoapplication.model.GithubRepo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Dora on 7/24/2017.
 */

public interface RestApi {

    @GET("/users/{user}/repos")
    Call<List<GithubRepo>> requestUserRepo(@Path("user") String user);

}
