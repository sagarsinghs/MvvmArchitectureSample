package sangamsagar.learningroom.CodingInFLowRetrofit;

import com.google.gson.annotations.SerializedName;

public class NewspaperModelClass {

    /*"author": "Al Jazeera",
            "title": "Iran rebukes US over rumoured IRGC 'terrorist' designation",
            "description": "Move by Washington to blacklist elite security organisation would draw reciprocal action, officials in Tehran say.",
            "url": "https://www.aljazeera.com/news/2019/04/iran-rebukes-rumoured-irgc-terrorist-designation-190407160100794.html",
            "urlToImage": "https://www.aljazeera.com/mritems/Images/2019/4/7/447e80c6d961415c843b8b3d16e95358_18.jpg",
            "publishedAt": "2019-04-07T18:16:36Z",
            "content":*/

    @SerializedName("title")
    public  String title;

    @SerializedName("description")
    public  String description;

    @SerializedName("url")
    public  String url;

    @SerializedName("publishedAt")
    public  String publishedAt;

    @SerializedName("content")
    public  String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
