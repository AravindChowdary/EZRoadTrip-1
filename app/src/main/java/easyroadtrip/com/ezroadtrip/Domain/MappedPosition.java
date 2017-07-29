package easyroadtrip.com.ezroadtrip.Domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by aravindchowdary on 7/29/17.
 */
@DatabaseTable(tableName = "MappedPosition")
public class MappedPosition {
    @DatabaseField
    private Double latitude;
    @DatabaseField
    private Double longitude;

    public MappedPosition() {
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
