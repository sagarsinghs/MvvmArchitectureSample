package sangamsagar.learningroom.CodingInFLowRetrofit;


import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts(@Query("userId") Integer[] userId,
                              @Query("_sort") String sort,
                              @Query("_order") String order);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id")int postId);

    @GET
    Call<List<Comment>> getComments(@Url String url);


    //for userId=23&title=New%20Title&body=New%20Text
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String,String> fields);

    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id,@Body Post post);

    @PATCH("posts/{id}")
        Call<Post> patchPost(@Path("id") int id,@Body Post post);

    @DELETE("posts/{id}")
         Call<Void> deletePost(@Path("id") int id);


    //for the newspaper
    @GET("https://newsapi.org/v2/everything?sources=al-jazeera-english&apiKey=dd58977a4b15400da37c91936335d8dd")
    Call<JsonArrayResponse> getEmployeeList();






}
