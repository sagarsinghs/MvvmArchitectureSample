package sangamsagar.learningroom.CodingInFLowRetrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sangamsagar.learningroom.CodingInFLowRetrofit.network.APICALL;
import sangamsagar.learningroom.CodingInFLowRetrofit.network.RetroFitClass;
import sangamsagar.learningroom.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

;

public class Main2Activity extends AppCompatActivity {
    private TextView textViewResult;
    List<NewspaperModelClass> arrayList;
    String s;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewResult = (TextView) findViewById(R.id.textViewResult);

      /*  HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient =new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
*/
        arrayList = new ArrayList<>();

     //   retrofit_class_creaetion();
      /*  Retrofit retrofit  =  new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
              //  .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
               *//* .client(okHttpClient)*//*
                .build();*/


       // jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

       // getPosts();
      //  getComments();
        //createPost();
       // updatePost();

        //deletePost();
        getDetailsNewspaper();
    }



    private void getPosts() {
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts( new Integer[]{2,4,1,6},"id","desc");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID" + post.getId() + "\n";
                    content += "User ID" + post.getUserId() + "\n";
                    content += "Title : " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                textViewResult.setText(t.getMessage());
            }
        });

    }
        private void getComments() {

        //Call<List<Comment>> call = jsonPlaceHolderApi.getComments(3);
            Call<List<Comment>> call =  jsonPlaceHolderApi.getComments("posts/3/comments");
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Comment> comments = response.body();
                for (Comment comment : comments) {
                    String content = "";
                    content += "ID: " + comment.getId() + "\n";
                    content += "Post ID: " + comment.getPostId() + "\n";
                    content += "Name: " + comment.getName() + "\n";
                    content += "Email: " + comment.getEmail() + "\n";
                    content += "Text: " + comment.getText() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }


        });
    }

    private  void createPost()
    {
        //Post post = new Post(23,"New Title" , "New text");
      //  Call<Post>  call = jsonPlaceHolderApi.createPost(post);
        //Call<Post> call = jsonPlaceHolderApi.createPost(23,"New Title ","New Text");

        Map<String,String> fields = new HashMap<>();
        fields.put("userId","25");
        fields.put("title","New Title");

        Call<Post> call =  jsonPlaceHolderApi.createPost(fields);


        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(!response.isSuccessful())
                {
                    textViewResult.setText("Code"  + response.code());
                    return;
                }

                Post postresponse = response.body();
                String content = " ";
                content += "Code :" +response.code() +"\n";
                content += "ID: " + postresponse.getId() + "\n";
                content += "User ID: " + postresponse.getUserId() + "\n";
                content += "Title: " + postresponse.getTitle() + "\n";
                content += "Text: " + postresponse.getText() + "\n\n";

                textViewResult.setText(content);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

    }

    public  void updatePost()
    {
        Post post = new Post(12,null,"New Text");
       // Call<Post> call = jsonPlaceHolderApi.putPost(5,post);
        Call<Post> call =jsonPlaceHolderApi.patchPost(1,post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(!response.isSuccessful())
                {
                    textViewResult.setText("Code"  + response.code());
                    return;
                }

                Post postresponse = response.body();
                String content = " ";
                content += "Code :" +response.code() +"\n";
                content += "ID: " + postresponse.getId() + "\n";
                content += "User ID: " + postresponse.getUserId() + "\n";
                content += "Title: " + postresponse.getTitle() + "\n";
                content += "Text: " + postresponse.getText() + "\n\n";

                textViewResult.setText(content);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });


    }

    private  void deletePost()
    {
        Call<Void> call = jsonPlaceHolderApi.deletePost(5);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                textViewResult.setText("Code : " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                textViewResult.setText(t.getMessage()) ;

            }
        });
    }

    public  void getDetailsNewspaper()
    {

        APICALL apicall = RetroFitClass.getAPIinstance();
        Call<JsonArrayResponse> employeeListCall = apicall.getEmployeeList();
        employeeListCall.enqueue(new Callback<JsonArrayResponse>() {
            @Override
            public void onResponse(Call<JsonArrayResponse> call, Response<JsonArrayResponse> response) {

                Log.d("TheNewspaperModel",response.body().getNewspaperModel().get(0).toString());
                arrayList = response.body().getNewspaperModel();
                Log.d("TheNewspaperModel",arrayList.toString());

                for(int i =0;i<arrayList.size();i++)
                {
                    Log.d("AdapterObainrinr",arrayList.get(i).getTitle());
                    Log.d("AdapterObainrinr",arrayList.get(i).getDescription());
                  //  Log.d("AdapterObainrinr",arrayList.get(i).getContent());
                    Log.d("AdapterObainrinr",arrayList.get(i).getPublishedAt()+"\n\n\n\n");

                     s = ( arrayList.get(i).getTitle() +arrayList.get(i).getDescription()+arrayList.get(i).getPublishedAt());


                }
               /* customAdapter = new CustomAdapter(Main2Activity.this,arrayList);
                listView.setAdapter(customAdapter);
*/
                textViewResult.setText(s);
            }

            @Override
            public void onFailure(Call<JsonArrayResponse> call, Throwable t) {

            }
        });

     /* Call<JsonArrayResponse> jsonArrayResponseCall = jsonPlaceHolderApi.getEmployeeList();
      jsonArrayResponseCall.enqueue(new Callback<JsonArrayResponse>() {
          @Override
          public void onResponse(Call<JsonArrayResponse> call, Response<JsonArrayResponse> response) {

              arrayList = response.body().getNewspaperModel();
              Log.d("TheNewspaperModel",arrayList.get(0).toString());
          }

          @Override
          public void onFailure(Call<JsonArrayResponse> call, Throwable t) {

          }
      });*/

        /*Call<JsonArrayResponse> call = api.reponseproduct();

        call.enqueue(new Callback<JsonArrayResponse>() {
            @Override
            public void onResponse(Call<JsonArrayResponse> call, Response<JsonArrayResponse> response) {

                if (!response.isSuccessful()) {
                    Log.d("ResponseReceivedNews", "ResponseNotFound");
                    return;
                }
                ArrayList<JsonArrayResponse.NewspaperModel> p = new ArrayList(response.body().getNewspaperModelClasses());
            }



            @Override
            public void onFailure(Call<JsonArrayResponse> call, Throwable t) {

            }

        });*/

    }
    }

   /*  Call<List<JsonArrayResponse>> call = jsonPlaceHolderApi.getDetails();
                         call.enqueue(new Callback<List<JsonArrayResponse>>() {*/
         /*   @Override
            public void onResponse(Call<List<JsonArrayResponse>> call, Response<List<JsonArrayResponse>> response) {
*//*
                if(!response.isSuccessful())
                {
                    Log.d("ResponseReceivedNews","ResponseNotFound");
                    return;
                }
                Log.d("ResponseReceivedNews",response.body().);


            }*/