package sangamsagar.learningroom.PlayingWithMvvmArchitecture;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface2 {

    /*@GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key")String api_key);*/

    @GET("movie/top_rated")
    Call<PlayingDetails> getDetailsResponse(@Query("api_key") String api_key);

    @DELETE("movie/top_rated")
    Call<Void>  deletePost(@Query("api_key") String api_key);

}
