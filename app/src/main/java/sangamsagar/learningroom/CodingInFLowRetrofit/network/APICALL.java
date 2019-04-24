package sangamsagar.learningroom.CodingInFLowRetrofit.network;

import retrofit2.Call;
import retrofit2.http.GET;
import sangamsagar.learningroom.CodingInFLowRetrofit.JsonArrayResponse;

/**
 * Created by lenovo on 3/18/2018.
 */

public interface APICALL {


    @GET("everything?sources=al-jazeera-english&apiKey=dd58977a4b15400da37c91936335d8dd")
    Call<JsonArrayResponse> getEmployeeList();

}
