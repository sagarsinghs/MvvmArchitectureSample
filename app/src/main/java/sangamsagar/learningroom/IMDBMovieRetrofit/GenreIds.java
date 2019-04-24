package sangamsagar.learningroom.IMDBMovieRetrofit;

import com.google.gson.annotations.SerializedName;

public class GenreIds {

    @SerializedName("genre_ids")
    private int genre_ids;

    public int getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(int genre_ids) {
        this.genre_ids = genre_ids;
    }
}
