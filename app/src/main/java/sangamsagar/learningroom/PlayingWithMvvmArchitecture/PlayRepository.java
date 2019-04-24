package sangamsagar.learningroom.PlayingWithMvvmArchitecture;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class PlayRepository {

private MyPlayAccessObject myPlayAccessObject;
private LiveData<List<PlayModel>> listLiveData;


public  PlayRepository(Application application)
{
    MyPlayDatabase myPlayDatabase = MyPlayDatabase.getInstance(application);
    myPlayAccessObject = myPlayDatabase.myPlayAccessObject();
    listLiveData = myPlayAccessObject.getPlayData();
}

public  void insert(PlayModel playModel)
{
    new InsertPlayAsyncTask(myPlayAccessObject).execute(playModel);
}

public LiveData<List<PlayModel>> getAllLiveData()
{
    return listLiveData;
}
private static  class InsertPlayAsyncTask extends AsyncTask<PlayModel,Void,Void>
    {

        private MyPlayAccessObject myPlayAccessObject;
        private InsertPlayAsyncTask(MyPlayAccessObject dataAccessObject)
        {
            this.myPlayAccessObject = dataAccessObject;
        }


        @Override
        protected Void doInBackground(PlayModel... playModels) {
            myPlayAccessObject.addPlayDetails(playModels[0]);
            return null;
        }
    }
}
