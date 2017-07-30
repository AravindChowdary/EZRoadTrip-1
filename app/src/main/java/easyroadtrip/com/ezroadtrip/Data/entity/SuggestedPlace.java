package easyroadtrip.com.ezroadtrip.Data.entity;

import android.support.annotation.StringRes;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Dora on 7/30/2017.
 */

public class SuggestedPlace implements Serializable {

    @SerializedName("position")
    private double[] mPosition;

    @SerializedName("place_id")
    private String mPlaceId;

    @SerializedName("rating")
    private float mRating;

    @SerializedName("id")
    private String mId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("fee")
    private String mFee;

    @SerializedName("duration")
    private String mDuration;

    @SerializedName("address")
    private String mAddress;

    @SerializedName("thingstodo")
    private String mThingsToDo;

    public SuggestedPlace() {
    }

    public double[] getPosition() {
        return mPosition;
    }

    public String getPlaceId() {
        return mPlaceId;
    }

    public float getRating() {
        return mRating;
    }

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getFee() {
        return mFee;
    }

    public String getDuration() {
        return mDuration;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getThingsToDo() {
        return mThingsToDo;
    }

    @Override
    public String toString() {
        return "SuggestedPlace{" +
                "mPosition=" + Arrays.toString(mPosition) +
                ", mPlaceId='" + mPlaceId + '\'' +
                ", mRating=" + mRating +
                ", mId='" + mId + '\'' +
                ", mTitle='" + mTitle + '\'' +
                '}';
    }
}
