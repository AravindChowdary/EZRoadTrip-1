package easyroadtrip.com.ezroadtrip.Presentation.Navigator;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

import easyroadtrip.com.ezroadtrip.Data.entity.SuggestedPlace;
import easyroadtrip.com.ezroadtrip.Presentation.activity.HomeActivity;
import easyroadtrip.com.ezroadtrip.Presentation.activity.NewTripActivity;
import easyroadtrip.com.ezroadtrip.Presentation.activity.TripMapActivity;

/**
 * Created by Dora on 7/29/2017.
 */

public class Navigator {

    /**
     * Navigate to Home Screen
     * @param context
     */
    public static void navigateToHomeActivity(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        // By setting the flag to NEW_TASK AND CLEAR_TASK, it means we will clear previous activity
        // from the backstack. Therefore, after we click back it will exit the application.
        // It's good for splash screen.
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    /**
     * Navigate to NewTripActivity
     * @param context
     */
    public static void navigateToNewTripActivity(Context context) {
        Intent intent = new Intent(context, NewTripActivity.class);
        context.startActivity(intent);
    }

    /**
     * Navigate to TripMapActivity
     * @param context
     */
    public static void navigageToTripMapActivity(Context context, double startLat, double startLon,
                                                 double endLat, double endLon) {
        Intent intent = new Intent(context, TripMapActivity.class);
        intent.putExtra(TripMapActivity.ARG_FROM_LOCAL, TripMapActivity.NOT_FROM_LOCAL);
        intent.putExtra(TripMapActivity.ARG_START_LAT, startLat);
        intent.putExtra(TripMapActivity.ARG_START_LON, startLon);
        intent.putExtra(TripMapActivity.ARG_END_LAT, endLat);
        intent.putExtra(TripMapActivity.ARG_END_LON, endLon);
        context.startActivity(intent);
    }

    public static void navigateToTripMapActivity(Context context, List<SuggestedPlace> suggestedPlaceList) {
        Intent intent = new Intent(context, TripMapActivity.class);
        String gson = new Gson().toJson(suggestedPlaceList);
        intent.putExtra(TripMapActivity.ARG_FROM_LOCAL, TripMapActivity.FROM_LOCAL);
        intent.putExtra(TripMapActivity.ARG_PLACE_LIST, gson);
        context.startActivity(intent);
    }

}
