package sangamsagar.learningroom.IMDBMovieRetrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key")String api_key);

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id,@Query("api_key") String api_key);


}

/*   "total_results": 7101,
    "total_pages": 356,
    "results": [
        {
            "vote_count": 2026,
            "id": 19404,
            "video": false,
            "vote_average": 9,
            "title": "Dilwale Dulhania Le Jayenge",
            "popularity": 14.892,
            "poster_path": "/uC6TTUhPpQCmgldGyYveKRAu8JN.jpg",
            "original_language": "hi",
            "original_title": "दिलवाले दुल्हनिया ले जायेंगे",
            "genre_ids": [
                35,
                18,
                10749
            ],
            "backdrop_path": "/nl79FQ8xWZkhL3rDr1v2RFFR6J0.jpg",
            "adult": false,
            "overview": "Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.",
            "release_date": "1995-10-20"
        },*/