package easyroadtrip.com.ezroadtrip.Presentation.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.here.android.mpa.common.GeoCoordinate;
import com.here.android.mpa.common.OnEngineInitListener;
import com.here.android.mpa.mapping.Map;
import com.here.android.mpa.mapping.MapFragment;

import java.util.ArrayList;
import java.util.List;

import easyroadtrip.com.ezroadtrip.R;

public class BasicMapActivity extends BaseActivity {

    private final String TAG = BasicMapActivity.class.getName();

    Map mMap;
    MapFragment mMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_map);
    }

    @Override
    protected void onStart() {
        super.onStart();
        requestPermission();
    }

    /**
     * Initialize map
     */
    public void initializeMap() {
        // Search for the map fragment to finish setup by calling init().
        mMapFragment = (MapFragment)getFragmentManager().findFragmentById(
                R.id.mapfragment);
        mMapFragment.init(new OnEngineInitListener() {
            @Override
            public void onEngineInitializationCompleted(OnEngineInitListener.Error error)
            {
                if (error == OnEngineInitListener.Error.NONE) {
                    // retrieve a reference of the map from the map fragment
                    mMap = mMapFragment.getMap();
                    // Set the map center to the Vancouver region (no animation)
                    mMap.setCenter(new GeoCoordinate(49.196261, -123.004773, 0.0),
                            Map.Animation.NONE);
                    // Set the zoom level to the average between min and max
                    mMap.setZoomLevel(
                            (mMap.getMaxZoomLevel() + mMap.getMinZoomLevel()) / 2);
                } else {
                    System.out.println("ERROR: Cannot initialize Map Fragment");
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "Map is initialized");
        if (requestCode == ASK_PERMISSION_REQUEST_CODE && permissions.length == grantResults.length) {
            initializeMap();
        }
    }

}
