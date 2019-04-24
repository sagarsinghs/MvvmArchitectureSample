package sangamsagar.learningroom.RetrofiRadiusIntern;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface1 {

    @GET("radius-intern-mobile/master/users.json")
      Call<DetailsResponse> getDetailsResponse();

}
