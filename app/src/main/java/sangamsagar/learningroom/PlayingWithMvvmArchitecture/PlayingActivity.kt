package sangamsagar.learningroom.PlayingWithMvvmArchitecture

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import sangamsagar.learningroom.R

class PlayingActivity : AppCompatActivity() {
    private var playViewModel: PlayViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvmactivity)

        myPlayDatabase = Room.databaseBuilder(applicationContext, MyPlayDatabase::class.java, "userdb")
            .allowMainThreadQueries().build()
        playViewModel = ViewModelProviders.of(this).get(PlayViewModel::class.java)


        // playViewModel.insert(note);

        playViewModel!!.playModel.observe(this, Observer {
            Toast.makeText(this@PlayingActivity, "Toast the data is updated successfully,", Toast.LENGTH_SHORT).show()
            //  adapter.setModelClasses(modelClasses);
        })


        /* myPlayDatabase = Room.databaseBuilder(getApplicationContext(), MyPlayDatabase.class, "userdb")
                .allowMainThreadQueries().build();
        playViewModel = ViewModelProviders.of(this).get(PlayViewModel.class);


       // playViewModel.insert(note);

        playViewModel.getPlayModel().observe(this, new Observer<List<PlayModel>>() {
            @Override
            public void onChanged(@Nullable List<PlayModel> testModels) {
                Toast.makeText(PlayingActivity.this, "Toast the data is updated successfully,", Toast.LENGTH_SHORT).show();
                //  adapter.setModelClasses(modelClasses);


            }

        });
*/
    }

    companion object {

        var myPlayDatabase: MyPlayDatabase
    }
}
