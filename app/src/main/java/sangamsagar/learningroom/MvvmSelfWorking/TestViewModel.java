package sangamsagar.learningroom.MvvmSelfWorking;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;


import java.util.List;

public class TestViewModel extends AndroidViewModel {


    private TestRepository repository;
    private LiveData<List<TestModel>> alltests;


    public TestViewModel(@NonNull Application application) {
        super(application);
        repository = new TestRepository(application);
        alltests = repository.getAllnotes();

    }

    public void insert(TestModel modelClass) {
        repository.insert(modelClass);
    }

    public LiveData<List<TestModel>> getAllNotes() {
        return alltests;

    }
}