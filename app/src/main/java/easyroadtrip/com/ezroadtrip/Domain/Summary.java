package easyroadtrip.com.ezroadtrip.Domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by aravindchowdary on 7/29/17.
 */

@DatabaseTable(tableName = "Summary")
public class Summary {
    @DatabaseField
    private int distance;
    @DatabaseField
    private int traffictime;
    @DatabaseField
    private int basetime;
    @DatabaseField
    private int traveltime;

    public Summary() {
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTraffictime() {
        return traffictime;
    }

    public void setTraffictime(int traffictime) {
        this.traffictime = traffictime;
    }

    public int getBasetime() {
        return basetime;
    }

    public void setBasetime(int basetime) {
        this.basetime = basetime;
    }

    public int getTraveltime() {
        return traveltime;
    }

    public void setTraveltime(int traveltime) {
        this.traveltime = traveltime;
    }
}
