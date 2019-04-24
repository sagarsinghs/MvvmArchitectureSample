package sangamsagar.learningroom.PlayingWithMvvmArchitecture;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;


import java.util.List;

public class PlayViewModel extends AndroidViewModel {

    private PlayRepository repository;
    private LiveData<List<PlayModel>> alltests;

    public PlayViewModel(@NonNull Application application) {
        super(application);
        repository = new PlayRepository(application);
        alltests = repository.getAllLiveData();

    }

    public void insert(PlayModel modelClass) {
        repository.insert(modelClass);
    }

    public LiveData<List<PlayModel>> getPlayModel() {
        return alltests;

    }
}
