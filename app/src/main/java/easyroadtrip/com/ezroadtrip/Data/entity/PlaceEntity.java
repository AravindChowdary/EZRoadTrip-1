package easyroadtrip.com.ezroadtrip.Data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by Dora on 7/30/2017.
 */

public class PlaceEntity {

    @SerializedName("title")
    private String mTitle;

    @SerializedName("highlightedTitle")
    private String mHighLightTitle;

    @SerializedName("vicinity")
    private String mVicinity;

    @SerializedName("highlightedVicinity")
    private String mHighLightVicinity;

    @SerializedName("position")
    private double[] mPositions;

    @SerializedName("category")
    private String mCategory;

    @SerializedName("href")
    private String mHref;

    @SerializedName("type")
    private String mType;

    public PlaceEntity() {
    }

    public String getTitle() {
        return mTitle;
    }

    public String getHighLightTitle() {
        return mHighLightTitle;
    }

    public String getVicinity() {
        return mVicinity;
    }

    public String getHighLightVicinity() {
        return mHighLightVicinity;
    }

    public double[] getPositions() {
        return mPositions;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getHref() {
        return mHref;
    }

    public String getType() {
        return mType;
    }

    @Override
    public String toString() {
        String vicinity = null;
        if (mVicinity != null) {
            vicinity = mVicinity.replaceAll("<(.*?)\\>"," ");//Removes all items in brackets
            vicinity = vicinity.replaceAll("<(.*?)\\\n"," ");//Must be undeneath
            vicinity = vicinity.replaceFirst("(.*?)\\>", " ");//Removes any connected item to the last bracket
            vicinity = vicinity.replaceAll("&nbsp;"," ");
            vicinity = vicinity.replaceAll("&amp;"," ");
        }

        return mTitle + ", " + vicinity;
    }
}
