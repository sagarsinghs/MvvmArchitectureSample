package sangamsagar.learningroom.IMDBMovieRetrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sangamsagar.learningroom.R;

public class IMDBActivity extends AppCompatActivity {

    private static final  String TAG =IMDBActivity.class.getSimpleName();

    private final  static  String API_KEY="7e8f60e325cd06e164799af1e317d7a7";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imdb);


        if(API_KEY.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Please obtin thenapi_keu",Toast.LENGTH_SHORT).show();
            return;
        }

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        //Call<MovieResponse> call = apiInterface.getTopRatedMovies(API_KEY);
          Call<MovieResponse> call   =  apiInterface.getMovieDetails(238,API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NotNull Call<MovieResponse> call, Response<MovieResponse> response) {

              //  List<Movie> movies = response.body().getResults().get(0).getGenreIds().get(0).getGenre_ids();

              //  List<Movie> movies = response.body().getResults();
               // List<GenreIds>  genreIds = movies.get(0).getGenreIds();
             //   String ss= response.body().getResults().get(0).getPopularity();


               // Log.d(TAG,"numberofmoviesreceived" + ss);

            }

            @Override
            public void onFailure(@NotNull Call<MovieResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
