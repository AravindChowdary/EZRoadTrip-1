package easyroadtrip.com.ezroadtrip.Presentation.Navigator;

import android.content.Context;
import android.content.Intent;

import easyroadtrip.com.ezroadtrip.Presentation.activity.HomeActivity;
import easyroadtrip.com.ezroadtrip.Presentation.activity.NewTripActivity;
import easyroadtrip.com.ezroadtrip.Presentation.activity.RouteSuggestionActivity;

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
     * Navigate to RouteSuggestionActivity
     * @param context
     */
    public static void navigageToRouteSuggestionActivity(Context context) {
        Intent intent = new Intent(context, RouteSuggestionActivity.class);
        context.startActivity(intent);
    }

}
