package easyroadtrip.com.ezroadtrip.Domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by aravindchowdary on 7/29/17.
 */
@DatabaseTable(tableName = "Place")
public class Place {
    @DatabaseField(generatedId = true)
    private long placeId;
    @DatabaseField
    private String imageUrl;
    @DatabaseField
    private String title;
    @DatabaseField
    private String Address;
    @DatabaseField
    private Float rating;
    @DatabaseField
    private long duration;

    public Place() {
    }

    public long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
