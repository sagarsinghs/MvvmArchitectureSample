package sangamsagar.learningroom.CodingInFLowRetrofit;

import com.google.gson.annotations.SerializedName;

public class Comment {

    public int postId;

    public int id;

    public String name;

    public String email;

    @SerializedName("body")
    private String text;

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getText() {
        return text;
    }
}
