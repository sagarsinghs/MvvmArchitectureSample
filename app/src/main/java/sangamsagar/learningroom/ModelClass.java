package sangamsagar.learningroom;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Newspaper")
public class ModelClass {
  /*  @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

*//*    public int getId() {
        return id;
    }*//*
*/
    @ColumnInfo(name ="title")
    private String title;

    @ColumnInfo(name="heading")
    private String description;

   /* public ModelClass(String title, String description, int i) {
    }

    public String getTitle() {
        return title;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
*/
   /* @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("published")
    private String published;

    @SerializedName("content")
    private String content;*/


    @PrimaryKey(autoGenerate = true)
    private int priority;

    public ModelClass(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    /*public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }*/

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

}
