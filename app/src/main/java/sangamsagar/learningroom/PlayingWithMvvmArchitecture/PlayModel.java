package sangamsagar.learningroom.PlayingWithMvvmArchitecture;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;


@Entity(tableName = "Playing")
public class PlayModel {

   /* @SerializedName("adult")
    private Boolean adult;*/



    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }


    @SerializedName("video")
    private Boolean video;

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    @SerializedName("title")
    private String budget;

    @NonNull
    @PrimaryKey
    @SerializedName("id")
    private int id;
/*

    @SerializedName("imdb_id")
    private String imdb_id;
*/

    @SerializedName("original_language")
    private String original_language;

    /*public PlayModel(String adult, String budget, String id, String imdb_id, String original_language) {
        this.adult = adult;
        this.budget = budget;
        this.id = id;
        this.imdb_id = imdb_id;
        this.original_language = original_language;
    }*/


}
