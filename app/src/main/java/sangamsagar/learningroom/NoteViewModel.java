package sangamsagar.learningroom;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository repository;
    private LiveData<List<ModelClass>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllnotes();

    }

    public  void insert(ModelClass modelClass)
    {
        repository.insert(modelClass);
    }
    public  LiveData<List<ModelClass>> getAllNotes()
    {
        return allNotes;
    }
}
