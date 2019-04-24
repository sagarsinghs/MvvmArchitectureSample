package sangamsagar.learningroom.RetrofiRadiusIntern;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("street")
    private String street;

    @SerializedName("city")
    private String city;

    @SerializedName("coordinates")
    private Coordinates coordinates;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
