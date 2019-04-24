package sangamsagar.learningroom.MvvmSelfWorking;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Response;
import sangamsagar.learningroom.RetrofiRadiusIntern.ApiClient1;
import sangamsagar.learningroom.RetrofiRadiusIntern.ApiInterface1;
import sangamsagar.learningroom.RetrofiRadiusIntern.DetailsResponse;

@Database(entities = {TestModel.class},version = 1,exportSchema = false)
public abstract  class MyTestDatabase  extends RoomDatabase {

    public static RequestQueue requestQueue;
    private static StringRequest stringRequest;

    static String URL_FOR_REGISTRATION = "https://raw.githubusercontent.com/iranjith4/radius-intern-mobile/master/users.json";
    static Context context;

    public static MyTestDatabase instance;

    public abstract MyTestAccessObject myTestAccessObject();


    public static synchronized MyTestDatabase getInstance(Context context) {
        requestQueue = Volley.newRequestQueue(context);

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                     MyTestDatabase.class, "test_database")
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
        private MyTestAccessObject myDataAccessObject;
        private PopulateDBAsyncTask(MyTestDatabase db)
        {
            myDataAccessObject= db.myTestAccessObject();
        }

        @Override
        protected Void doInBackground(Void... voids) {

      //**************************** 1.      //THIS PART IS USING HE THE RETROFIT**********************//

            ApiInterface1 apiInterface = ApiClient1.getClient().create(ApiInterface1.class);
            Log.d("ApiReferenceIs",apiInterface.toString());

            Call<DetailsResponse> call = apiInterface.getDetailsResponse();
            Log.d("CallingInterface",call.toString());
            call.enqueue(new retrofit2.Callback<DetailsResponse>() {
                @Override
                public void onResponse(@NotNull Call<DetailsResponse> call, Response<DetailsResponse> response) {

                    String ss = response.body().getDetails().get(0).getLocation().getCoordinates().getLatitude().trim();

                    String ss1  = response.body().getDetails().get(1).getGender();
                    Log.d("MyTestDatabaseIS",ss);
                    Log.d("MyTestdaTAbASE2",ss1);

                }

                @Override
                public void onFailure(Call<DetailsResponse> call, Throwable t) {

                }

            });

            //**************************** 2.      // THIS PART WAS USING THE VOLLEY ************************//

          /*  stringRequest = new StringRequest(Request.Method.GET, URL_FOR_REGISTRATION, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    JSONObject j1 = null;
                    try {
                        JSONObject jObj = new JSONObject(response.trim());
                        JSONArray jsonArray = jObj.getJSONArray("results");


                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jj = jsonArray.getJSONObject(i);
                            String gender = jj.getString("gender");
                            String email = jj.getString("email");

                            Log.d("theValueComingFromApi",gender+ email);

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

            requestQueue.add(stringRequest);*/
            return null;
        }
    }

}
