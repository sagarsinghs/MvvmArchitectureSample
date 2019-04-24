package sangamsagar.learningroom;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class NoteRepository {
    private  MyDataAccessObject noteDao;
    private LiveData<List<ModelClass>> allnotes;

    public  NoteRepository(Application application)
    {
        MyAppDatabase database = MyAppDatabase.getInstance(application);
        noteDao = database.myDataAccessObject();
        allnotes = noteDao.getAllNotes();
    }

    public  void insert(ModelClass modelClass)
    {
        new InsertNoteAsyncTask(noteDao).execute(modelClass);
    }

    public  void delete(ModelClass modelClass)
    {
        new DeleteNoteAsyncTask(noteDao).execute(modelClass);
    }

    public LiveData<List<ModelClass>> getAllnotes()
    {
        return  allnotes;
    }

    private static  class InsertNoteAsyncTask extends AsyncTask<ModelClass,Void,Void>
    {
        private MyDataAccessObject myDataAccessObject;
        private InsertNoteAsyncTask(MyDataAccessObject dataAccessObject)
        {
            this.myDataAccessObject =  dataAccessObject;
        }

        @Override
        protected Void doInBackground(ModelClass... modelClasses) {
            myDataAccessObject.addDetails(modelClasses[0]);
            return  null;
        }
    }
    private static class DeleteNoteAsyncTask extends AsyncTask<ModelClass,Void,Void>
    {
        private  MyDataAccessObject myDataAccessObject;
        private DeleteNoteAsyncTask(MyDataAccessObject dataAccessObject)
        {
            this.myDataAccessObject=dataAccessObject;
        }

        @Override
        protected Void doInBackground(ModelClass... modelClasses) {
            myDataAccessObject.deleteUser(modelClasses[0]);
            return  null;
        }
    }
}
