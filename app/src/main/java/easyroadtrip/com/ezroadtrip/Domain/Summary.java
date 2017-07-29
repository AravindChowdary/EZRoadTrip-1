package easyroadtrip.com.ezroadtrip.Domain;

/**
 * Created by aravindchowdary on 7/29/17.
 */

public class Summary {
    private int distance;
    private int traffictime;
    private int basetime;
    private int traveltime;

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
