package sangamsagar.learningroom.RetrofiRadiusIntern;

import com.google.gson.annotations.SerializedName;

public class Details {

    @SerializedName("gender")
    private String gender;

/*   private List<Integer> genreIds = new ArrayList<Integer>();*/

    @SerializedName("name")
    private Name name;

    @SerializedName("location")
    private  Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



}
