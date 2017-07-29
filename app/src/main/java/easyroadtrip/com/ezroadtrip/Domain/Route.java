package easyroadtrip.com.ezroadtrip.Domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import static android.R.attr.data;

/**
 * Created by aravindchowdary on 7/29/17.
 */

@DatabaseTable (tableName = "Route")
public class Route {
    @DatabaseField(generatedId = true)
    private long routeId;

    @DatabaseField
    private Waypoint waypoint;

    @DatabaseField
    private Summary summary;

    public Route() {
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

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
