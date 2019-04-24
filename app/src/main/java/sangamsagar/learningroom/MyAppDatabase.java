package sangamsagar.learningroom;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Database(entities ={ModelClass.class},version = 1 ,exportSchema = false)
public abstract  class MyAppDatabase  extends RoomDatabase {

    public static RequestQueue mRequestQueue;
    private static StringRequest mStringRequest;

        static String URL_FOR_REGISTRATION = "https://newsapi.org/v2/everything?sources=al-jazeera-english&apiKey=dd58977a4b15400da37c91936335d8dd";
        static  Context context;

    private  static MyAppDatabase instance;
    public  abstract MyDataAccessObject myDataAccessObject();


    //Only one thread at a time can access this method
    public  static synchronized MyAppDatabase getInstance(Context context)
    {
        mRequestQueue = Volley.newRequestQueue(context);
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MyAppDatabase.class,"note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomcallback)
                    .allowMainThreadQueries()
                    .build();

        }
        return instance;
    }

    private  static  RoomDatabase.Callback roomcallback = new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db)
        {
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();
        }
    };

    public static class PopulateDBAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private  MyDataAccessObject myDataAccessObject;
        private PopulateDBAsyncTask(MyAppDatabase db)
        {
            myDataAccessObject= db.myDataAccessObject();
        }

        @Override
        protected Void doInBackground(Void... voids) {


         /*   GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

            Call<List<ModelClass>> call = service.getAllPhotos();
            call.enqueue(new Callback<List<ModelClass>>(){

                @Override
                public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {

                    //  generateDataList(response.body());
                    Log.d("ResponseObtained", String.valueOf(response));
                }

                @Override
                public void onFailure(Call<List<ModelClass>> call, Throwable t) {

                    Toast.makeText(context, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                }
            });*/



        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, URL_FOR_REGISTRATION, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

            JSONObject j1 = null;
            try {
                JSONObject jObj = new JSONObject(response.trim());
                JSONArray jsonArray = jObj.getJSONArray("articles");


                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jj = jsonArray.getJSONObject(i);
                    String author = jj.getString("author");
                    String title = jj.getString("title");
                    String description = jj.getString("description");
                    String published = jj.getString("publishedAt");
                    String content = jj.getString("content");
                    String url_image = jj.getString("urlToImage");
                    String url = jj.getString("url");

                    Log.d("theValueComingFromApi",title + description);
                    myDataAccessObject.addDetails(new ModelClass(title, description, i+1));

                           /* myDataAccessObject.addDetails(new ModelClass("Title 2", "Description 2", 2));
                            myDataAccessObject.addDetails(new ModelClass("Title 3", "Description 3", 3));*/

                }

            } catch (JSONException e1) {
                e1.printStackTrace();

            }

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

            Toast.makeText(context, "You have got the error here", Toast.LENGTH_LONG).show();//display the response on screen

            Log.i("Findingtheerroe", "Error :" + error.toString());
        }
    });

            mRequestQueue.add(mStringRequest);

         /*   myDataAccessObject.addDetails(new ModelClass("Title 1", "Description 1", 1));
            myDataAccessObject.addDetails(new ModelClass("Title 2", "Description 2", 2));
            myDataAccessObject.addDetails(new ModelClass("Title 3", "Description 3", 3));*/
            return null;
    }
    }
   // private st

}
