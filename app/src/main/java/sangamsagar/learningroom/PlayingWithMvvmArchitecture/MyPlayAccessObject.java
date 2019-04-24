package sangamsagar.learningroom.PlayingWithMvvmArchitecture;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyPlayAccessObject {

    @Insert
    public void addPlayDetails(PlayModel playModel);

    @Query("Select * From Playing")
    LiveData<List<PlayModel>> getPlayData();




}
