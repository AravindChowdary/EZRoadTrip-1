package easyroadtrip.com.ezroadtrip.Domain;

/**
 * Created by aravindchowdary on 7/29/17.
 */

public class Route {
    private Waypoint waypoint;
    private Summary summary;

    public Waypoint getWaypoint() {
        return waypoint;
    }

    public void setWaypoint(Waypoint waypoint) {
        this.waypoint = waypoint;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }
}
