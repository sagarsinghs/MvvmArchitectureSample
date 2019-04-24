package sangamsagar.learningroom.PlayingWithMvvmArchitecture;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlayingDetails  {

    @SerializedName("results")
    private List<PlayModel> playModels;

    public List<PlayModel> getPlayModels() {
        return playModels;
    }

    public void setPlayModels(List<PlayModel> playModels) {
        this.playModels = playModels;
    }
}
