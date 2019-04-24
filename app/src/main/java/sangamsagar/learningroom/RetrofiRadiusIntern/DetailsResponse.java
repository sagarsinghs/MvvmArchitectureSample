package sangamsagar.learningroom.RetrofiRadiusIntern;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailsResponse {

    @SerializedName("results")
    private List<Details> details;

    public List<Details> getDetails() {
        return details;
    }

    public void setDetails(List<Details> details) {
        this.details = details;
    }
}

