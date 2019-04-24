package sangamsagar.learningroom.network;

import retrofit2.Call;
import retrofit2.http.GET;
import sangamsagar.learningroom.ModelClass;

import java.util.List;

public interface GetDataService {

    @GET("/photos")
    Call<List<ModelClass>> getAllPhotos();
}
