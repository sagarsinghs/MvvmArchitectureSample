package sangamsagar.learningroom.MvvmSelfWorking;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "Testing")
public class TestModel {


    @PrimaryKey(autoGenerate = true)
    private int priority;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @ColumnInfo(name ="gender")
    private String gender;

    @ColumnInfo(name = "email")
    private String email;

    public TestModel(int priority, String gender, String email) {
        this.priority = priority;
        this.gender = gender;
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
