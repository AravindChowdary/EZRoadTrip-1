package easyroadtrip.com.ezroadtrip.Domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by aravindchowdary on 7/29/17.
 */

@DatabaseTable(tableName = "Waypoint")
public class Waypoint {
    @DatabaseField
    private Double linkId;
    @DatabaseField
    private MappedPosition mappedPosition ;
    @DatabaseField
    private OriginalPosition originalPosition;
    @DatabaseField
    private Double spot;
    @DatabaseField
    private String mappedRoadName;
    @DatabaseField
    private String label;
    @DatabaseField
    private Double shapeIndex;

    public Double getLinkId() {
        return linkId;
    }

    public void setLinkId(Double linkId) {
        this.linkId = linkId;
    }

    public MappedPosition getMappedPosition() {
        return mappedPosition;
    }

    public void setMappedPosition(MappedPosition mappedPosition) {
        this.mappedPosition = mappedPosition;
    }

    public OriginalPosition getOriginalPosition() {
        return originalPosition;
    }

    public void setOriginalPosition(OriginalPosition originalPosition) {
        this.originalPosition = originalPosition;
    }

    public Double getSpot() {
        return spot;
    }

    public void setSpot(Double spot) {
        this.spot = spot;
    }

    public String getMappedRoadName() {
        return mappedRoadName;
    }

    public void setMappedRoadName(String mappedRoadName) {
        this.mappedRoadName = mappedRoadName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getShapeIndex() {
        return shapeIndex;
    }

    public void setShapeIndex(Double shapeIndex) {
        this.shapeIndex = shapeIndex;
    }
}
