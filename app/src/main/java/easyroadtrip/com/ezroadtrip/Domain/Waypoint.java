package easyroadtrip.com.ezroadtrip.Domain;

/**
 * Created by aravindchowdary on 7/29/17.
 */

public class Waypoint {
    private Double linkId;
    private Double[] mappedPosition;
    private Double originalPosition;
    private Double spot;
    private String mappedRoadName;
    private String label;
    private Double shapeIndex;

    public Double getLinkId() {
        return linkId;
    }

    public void setLinkId(Double linkId) {
        this.linkId = linkId;
    }

    public Double[] getMappedPosition() {
        return mappedPosition;
    }

    public void setMappedPosition(Double[] mappedPosition) {
        this.mappedPosition = mappedPosition;
    }

    public Double getOriginalPosition() {
        return originalPosition;
    }

    public void setOriginalPosition(Double originalPosition) {
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
