package sangamsagar.learningroom.MvvmSelfWorking;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import sangamsagar.learningroom.R;

import java.util.List;

public class ActivityClass extends AppCompatActivity {

    public static MyTestDatabase myTestDatabasey;
    private TestViewModel testViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvmactivity);

        myTestDatabasey = Room.databaseBuilder(getApplicationContext(), MyTestDatabase.class, "userdb").allowMainThreadQueries().build();
        testViewModel = ViewModelProviders.of(this).get(TestViewModel.class);

        TestModel note = new TestModel(1, "description", "priority");
        testViewModel.insert(note);

        testViewModel.getAllNotes().observe(this, new Observer<List<TestModel>>() {
            @Override
            public void onChanged(@Nullable List<TestModel> testModels) {
                Toast.makeText(ActivityClass.this, "Toast the data is updated successfully,", Toast.LENGTH_SHORT).show();
                //  adapter.setModelClasses(modelClasses);


            }

        });



    }
}
