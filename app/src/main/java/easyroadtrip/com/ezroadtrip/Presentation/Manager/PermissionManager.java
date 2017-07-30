package easyroadtrip.com.ezroadtrip.Presentation.Manager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dora on 7/29/2017.
 */

public class PermissionManager {

    public static final int ASK_PERMISSION_REQUEST_CODE = 1;

    /**
     * Request List of permissions of the application
     */
    public static void requestPermission(AppCompatActivity activity) {

        final List<String> requiredSDKPermissions = new ArrayList<String>();
        requiredSDKPermissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        requiredSDKPermissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        requiredSDKPermissions.add(Manifest.permission.INTERNET);
        requiredSDKPermissions.add(Manifest.permission.ACCESS_WIFI_STATE);
        requiredSDKPermissions.add(Manifest.permission.ACCESS_NETWORK_STATE);
        requiredSDKPermissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        final List<String> missingPermissions = new ArrayList<String>();
        // check all required dynamic permissions
        for (final String permission : requiredSDKPermissions) {
            final int result = ContextCompat.checkSelfPermission(activity, permission);
            if (result != PackageManager.PERMISSION_GRANTED) {
                missingPermissions.add(permission);
            }
        }
        if (!missingPermissions.isEmpty()) {
            // request all missing permissions
            final String[] permissions = missingPermissions
                    .toArray(new String[missingPermissions.size()]);
            ActivityCompat.requestPermissions(activity, permissions, ASK_PERMISSION_REQUEST_CODE);
        } else {
            final int[] grantResults = new int[requiredSDKPermissions.size()];
            Arrays.fill(grantResults, PackageManager.PERMISSION_GRANTED);
//            onRequestPermissionsResult(ASK_PERMISSION_REQUEST_CODE, requiredSDKPermissions,
//                    grantResults);
        }    }

}
