package sangamsagar.learningroom.PlayingWithMvvmArchitecture;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import retrofit2.Call;
import retrofit2.Response;

@Database(entities={PlayModel.class},version =2,exportSchema =false)
public abstract class MyPlayDatabase extends RoomDatabase {

    public static MyPlayDatabase instance;

    public abstract MyPlayAccessObject myPlayAccessObject();


    public static synchronized MyPlayDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                       MyPlayDatabase.class, "test_database")
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
            new MyPlayDatabase.PopulateDBAsyncTask(instance).execute();
        }
    };

    public static class PopulateDBAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private MyPlayAccessObject myDataAccessObject;
        private PopulateDBAsyncTask(MyPlayDatabase db)
        {
            myDataAccessObject= db.myPlayAccessObject();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            //**************************** 1.      //THIS PART IS USING THE RETROFIT**********************//

            ApiInterface2 apiInterface = ApiClient2.getClient().create(ApiInterface2.class);
            Log.d("ApiReferenceIs", apiInterface.toString());

            //FOR UPDATING THE COMMANDS

           /* Call<PlayingDetails> call = apiInterface.getDetailsResponse("7e8f60e325cd06e164799af1e317d7a7");
            Log.d("CallingInterface", call.toString());
            call.enqueue(new retrofit2.Callback<PlayingDetails>() {
                @Override
                public void onResponse(@NotNull Call<PlayingDetails> call, Response<PlayingDetails> response) {

                    //Boolean ss = response.body().getPlayModels().get(0).getVideo().booleanValue();
                    for(int i =0;i<response.body().getPlayModels().size();i++) {
                        String ss1 = response.body().getPlayModels().get(i).getOriginal_language();
                        //  String ss1 = response.body().getDetails().get(1).getGender();
                        // Log.d("MyPlayDatabaseIS", String.valueOf(ss));
                        Log.d("MyPlayDatabaseIS", ss1);

                    }
                }

                @Override
                public void onFailure(Call<PlayingDetails> call, Throwable t) {

                }

            });*/

            //FOR DELETING THE COMMANDS

            Call<Void> call1  =  apiInterface.deletePost("7e8f60e325cd06e164799af1e317d7a7");
            call1.enqueue(new retrofit2.Callback<Void>()
            {
                @Override
                public void onResponse(Call<Void> call1, Response<Void> response) {

                        Log.d("DataISGettinDeleted","Data Deleted");

                }

                @Override
                public void onFailure(Call<Void> call1, Throwable t) {

                }
            });
            return  null;
        }
}}
