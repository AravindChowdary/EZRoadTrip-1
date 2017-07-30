package easyroadtrip.com.ezroadtrip.Domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by aravindchowdary on 7/29/17.
 */
@DatabaseTable(tableName = "OriginalPosition")
public class OriginalPosition {
    @DatabaseField
    private Double latitude;
    @DatabaseField
    private Double longitude;

    public OriginalPosition() {
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
