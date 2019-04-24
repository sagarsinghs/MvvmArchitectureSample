package sangamsagar.learningroom.MvvmSelfWorking;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyTestAccessObject {

    @Insert
    public  void  addDetails(TestModel testModel);

    @Query("SELECT * FROM Testing")
    LiveData<List<TestModel>> getAllDetails();


}
