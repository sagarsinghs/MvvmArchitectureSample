package sangamsagar.learningroom.CodingInFLowRetrofit;

import com.google.gson.annotations.SerializedName;

public class Post {
    private  int userId;
    private  int id;
    public String title;

    //body is the name that is coming from the json key part.
    @SerializedName("body")
    private  String text;


    public Post(int userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }


    public  int getUserId()
    {
        return  userId;
    }
    public  int getId()
    {
        return id;
    }
    public  String getTitle()
    {
        return  title;
    }

    public String getText()
    {
        return text;
    }
}
