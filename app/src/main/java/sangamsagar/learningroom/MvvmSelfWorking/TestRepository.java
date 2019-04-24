package sangamsagar.learningroom.MvvmSelfWorking;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;


import java.util.List;

public class TestRepository {

    private MyTestAccessObject noteDao;
    private LiveData<List<TestModel>> allnotes;

    public  TestRepository(Application application)
    {
        MyTestDatabase database = MyTestDatabase.getInstance(application);
        noteDao = database.myTestAccessObject();
        allnotes = noteDao.getAllDetails();
    }
    public  void insert(TestModel testModel)
    {
        new InsertNoteAsyncTask(noteDao).execute(testModel);
    }

    public LiveData<List<TestModel>> getAllnotes()
    {
        return  allnotes;
    }

    private static  class InsertNoteAsyncTask extends AsyncTask<TestModel,Void,Void>
    {
        private MyTestAccessObject myDataAccessObject;
        private InsertNoteAsyncTask(MyTestAccessObject dataAccessObject)
        {
            this.myDataAccessObject =  dataAccessObject;
        }

        @Override
        protected Void doInBackground(TestModel... modelClasses) {
            myDataAccessObject.addDetails(modelClasses[0]);
            return  null;
        }
    }
}
