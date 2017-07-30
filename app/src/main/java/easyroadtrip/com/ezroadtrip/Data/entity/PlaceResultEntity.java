package easyroadtrip.com.ezroadtrip.Data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dora on 7/30/2017.
 */

public class PlaceResultEntity {

    @SerializedName("results")
    private List<PlaceEntity> mPlaceEntityList;

    public PlaceResultEntity() {
    }

    public List<PlaceEntity> getPlaceEntityList() {
        return mPlaceEntityList;
    }
}
