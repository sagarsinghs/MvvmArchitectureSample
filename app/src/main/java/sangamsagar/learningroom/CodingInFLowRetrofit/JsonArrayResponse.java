package sangamsagar.learningroom.CodingInFLowRetrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonArrayResponse {


    @SerializedName("articles")
    @Expose
    private List<NewspaperModelClass> newspaperModelClasses ;

    public List<NewspaperModelClass> getNewspaperModel() {
        return newspaperModelClasses;
    }

    public void setNewspaperModel(List<NewspaperModelClass> newspaperModelClasses) {
        this.newspaperModelClasses = newspaperModelClasses;
    }
}
