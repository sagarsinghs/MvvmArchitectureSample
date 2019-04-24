package sangamsagar.learningroom.RetrofiRadiusIntern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import sangamsagar.learningroom.R;

public class RadiusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radius);
        ApiInterface1 apiInterface = ApiClient1.getClient().create(ApiInterface1.class);

        Log.d("ApiReferenceIs",apiInterface.toString());

        Call<DetailsResponse> call = apiInterface.getDetailsResponse();
        Log.d("CallingInterface",call.toString());
        call.enqueue(new Callback<DetailsResponse>() {
            @Override
            public void onResponse(@NotNull Call<DetailsResponse> call, Response<DetailsResponse> response) {

                //  List<Movie> movies = response.body().getResults().get(0).getGenreIds().get(0).getGenre_ids();

                //  List<Movie> movies = response.body().getResults();
                // List<GenreIds>  genreIds = movies.get(0).getGenreIds();
               /* String ss= response.body().getResults().get(0).getGenreIds().toString();
                int ss1 = ss.indexOf(0);*/

                String ss = response.body().getDetails().get(0).getLocation().getCoordinates().getLatitude().trim();


                Log.d("detailsreceivedIs",ss);

            }

            @Override
            public void onFailure(Call<DetailsResponse> call, Throwable t) {

            }

        });
    }
}

