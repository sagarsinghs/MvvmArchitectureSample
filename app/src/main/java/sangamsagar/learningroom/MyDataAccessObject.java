package sangamsagar.learningroom;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDataAccessObject {

    @Insert
    public  void addDetails(ModelClass modelClass);

    /*@Query("select * from Newspaper")
    public List<ModelClass> getDetails();*/

    @Delete
    public  void deleteUser(ModelClass id);

    @Query("SELECT * FROM Newspaper")
    LiveData<List<ModelClass>> getAllNotes();

   /* @Query("SELECT * FROM NEWSPAPER")*/


}
