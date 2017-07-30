package easyroadtrip.com.ezroadtrip.Domain;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

import easyroadtrip.com.ezroadtrip.Data.entity.SuggestedPlace;

/**
 * Created by Dora on 7/29/2017.
 */
@DatabaseTable(tableName = "Trip")
public class Trip {

    @SerializedName("origin")
    private String mOrigin;
    @SerializedName("destination")
    private String mDestionation;
    @SerializedName("start_date")
    private String mStartDate;
    @SerializedName("end_date")
    private String mEndDate;
    @SerializedName("safety_alert")
    private boolean mSafetyAlert;
    @SerializedName("places")
    private List<SuggestedPlace> mSuggestedPlaceList;

    public Trip() {
    }

    public Trip(String origin, String destionation, String startDate, String endDate, boolean safetyAlert, List<SuggestedPlace> suggestedPlaceList) {
        mOrigin = origin;
        mDestionation = destionation;
        mStartDate = startDate;
        mEndDate = endDate;
        mSafetyAlert = safetyAlert;
        mSuggestedPlaceList = suggestedPlaceList;
    }

    public String getOrigin() {
        return mOrigin;
    }

    public String getDestionation() {
        return mDestionation;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public String getEndDate() {
        return mEndDate;
    }

    public boolean isSafetyAlert() {
        return mSafetyAlert;
    }

    public List<SuggestedPlace> getSuggestedPlaceList() {
        return mSuggestedPlaceList;
    }
}

