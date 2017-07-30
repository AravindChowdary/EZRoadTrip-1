package easyroadtrip.com.ezroadtrip.Presentation.activity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.here.android.mpa.common.GeoBoundingBox;
import com.here.android.mpa.common.GeoCoordinate;
import com.here.android.mpa.common.Image;
import com.here.android.mpa.common.OnEngineInitListener;
import com.here.android.mpa.mapping.Map;
import com.here.android.mpa.mapping.MapFragment;
import com.here.android.mpa.mapping.MapMarker;
import com.here.android.mpa.mapping.MapRoute;
import com.here.android.mpa.routing.CoreRouter;
import com.here.android.mpa.routing.RouteOptions;
import com.here.android.mpa.routing.RoutePlan;
import com.here.android.mpa.routing.RouteResult;
import com.here.android.mpa.routing.RouteWaypoint;
import com.here.android.mpa.routing.Router;
import com.here.android.mpa.routing.RoutingError;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import easyroadtrip.com.ezroadtrip.Data.datasource.network.RestClient;
import easyroadtrip.com.ezroadtrip.Data.entity.SuggestedPlace;
import easyroadtrip.com.ezroadtrip.Domain.Trip;
import easyroadtrip.com.ezroadtrip.Presentation.dialog.LoadingDialog;
import easyroadtrip.com.ezroadtrip.Presentation.fragment.PlaceListFragment;
import easyroadtrip.com.ezroadtrip.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TripMapActivity extends BaseActivity implements PlaceListFragment.OnFragmentInteractionListener {

    public static final boolean FROM_LOCAL = true;
    public static final boolean NOT_FROM_LOCAL = false;

    public static final String ARG_FROM_LOCAL = "FROM_LOCAL";
    public static final String ARG_START_LAT = "START_LAT";
    public static final String ARG_START_LON = "START_LON";
    public static final String ARG_END_LAT = "END_LAT";
    public static final String ARG_END_LON = "END_LON";
    public static final String ARG_PLACE_LIST = "PLACE_LIST";

    private boolean fromLocal;
    private double startLat;
    private double startLon;
    private double endLat;
    private double endLon;

    private MapFragment m_mapFragment;
    private Map m_map;
    private MapRoute m_mapRoute;

    @BindView(R.id.btnList)
    Button mBtnList;

    private List<SuggestedPlace> mSuggestedPlaceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_map);

        ButterKnife.bind(this);

        // display Actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.your_journey);


        // Load Data
        Bundle bundle = getIntent().getExtras();
        fromLocal = bundle.getBoolean(ARG_FROM_LOCAL);
        startLat = bundle.getDouble(ARG_START_LAT);
        startLon = bundle.getDouble(ARG_START_LON);
        endLat = bundle.getDouble(ARG_END_LAT);
        endLon = bundle.getDouble(ARG_END_LON);

        mBtnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlaceListFragment fragment = new PlaceListFragment();
                fragment.setSuggestedPlaces(mSuggestedPlaceList);
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, fragment)
                        .addToBackStack("PlaceList")
                        .commit();
            }
        });

        //TODO: InitMap Fragment
        initMapFragment();

        //TODO: Check loading trip map from server or local
        if (fromLocal) {
            String listJson =  bundle.getString(TripMapActivity.ARG_PLACE_LIST);
            Type type = new TypeToken<List<SuggestedPlace>>(){}.getType();
            mSuggestedPlaceList = new Gson().fromJson(listJson, type);

            // Create route based on information from the file
            Timer timer  = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            createRoute(mSuggestedPlaceList);
                        }
                    });
                }
            };
            timer.schedule(timerTask, 5000);
        } else {
            requestTripMapFromServier();
        }

    }

    public void requestTripMapFromServier() {
        LoadingDialog.show(this, "Loading, please wait...");
        RestClient.restApi.requestSuggestedRoute(startLat, startLon, endLat, endLon).enqueue(new Callback<List<SuggestedPlace>>() {
            @Override
            public void onResponse(Call<List<SuggestedPlace>> call, Response<List<SuggestedPlace>> response) {
                LoadingDialog.dismiss();
                if (response.body() != null) {
                    mSuggestedPlaceList = response.body();
                    createRoute(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<SuggestedPlace>> call, Throwable t) {
                LoadingDialog.dismiss();
            }
        });
    }

    private void initMapFragment() {
        /* Locate the mapFragment UI element */
        m_mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapfragment);

        if (m_mapFragment != null) {
            /* Initialize the MapFragment, results will be given via the called back. */
            m_mapFragment.init(new OnEngineInitListener() {
                @Override
                public void onEngineInitializationCompleted(OnEngineInitListener.Error error) {

                    if (error == Error.NONE) {
                        /* get the map object */
                        m_map = m_mapFragment.getMap();

                        /*
                         * Set the map center to the 4350 Still Creek Dr Burnaby BC (no animation).
                         */
                        m_map.setCenter(new GeoCoordinate(49.259149, -123.008555, 0.0),
                                Map.Animation.NONE);

                        /* Set the zoom level to the average between min and max zoom level. */
                        m_map.setZoomLevel((m_map.getMaxZoomLevel() + m_map.getMinZoomLevel()) / 2);
                    } else {
                        Toast.makeText(TripMapActivity.this,
                                "ERROR: Cannot initialize Map with error " + error,
                                Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    /**
     * Create route based on position of the SuggestedPlaces
     * @param suggestedPlaces: List of suggested places
     */
    private void createRoute(List<SuggestedPlace> suggestedPlaces) {
        /* Initialize a CoreRouter */
        CoreRouter coreRouter = new CoreRouter();

        /* Initialize a RoutePlan */
        RoutePlan routePlan = new RoutePlan();

        /*
         * Initialize a RouteOption.HERE SDK allow users to define their own parameters for the
         * route calculation,including transport modes,route types and route restrictions etc.Please
         * refer to API doc for full list of APIs
         */
        RouteOptions routeOptions = new RouteOptions();
        /* Other transport modes are also available e.g Pedestrian */
        routeOptions.setTransportMode(RouteOptions.TransportMode.CAR);
        /* Disable highway in this route. */
        routeOptions.setHighwaysAllowed(true);
        /* Calculate the shortest route available. */
        routeOptions.setRouteType(RouteOptions.Type.BALANCED);
        /* Calculate 1 route. */
        routeOptions.setRouteCount(5);
        /* Finally set the route option */
        routePlan.setRouteOptions(routeOptions);

        /**
         * Create RoutePoint and add marker to each position
         */
        for (SuggestedPlace item : suggestedPlaces) {

            //TODO: Define GeoCoordinate
            GeoCoordinate geoCoordinate = new GeoCoordinate(item.getPosition()[0], item.getPosition()[1]);

            // TODO: Define RouteWaypoint
            RouteWaypoint waypoint = new RouteWaypoint(geoCoordinate);

            // TODO: Define Image and set to marker
            Image icMaker = new Image();
            try {
                icMaker.setImageResource(R.mipmap.ic_marker);
            } catch (IOException e) {
                e.printStackTrace();
            }
            MapMarker mapMarker = new MapMarker(geoCoordinate, icMaker);

            // TODO: Add title to Marker
            mapMarker.setTitle(item.getTitle());
            Log.d("Place", " Title " + item.getTitle());
            mapMarker.showInfoBubble();

            // TODO: Set marker into Map or display marker on the map
            m_map.addMapObject(mapMarker);
            m_map.setCenter(geoCoordinate, Map.Animation.BOW);
            routePlan.addWaypoint(waypoint);
        }

        LoadingDialog.show(this, "Constructing map, please wait...");
        /* Trigger the route calculation,results will be called back via the listener */
        coreRouter.calculateRoute(routePlan,
                new Router.Listener<List<RouteResult>, RoutingError>() {
                    @Override
                    public void onProgress(int i) {
                        /* The calculation progress can be retrieved in this callback. */
                    }

                    @Override
                    public void onCalculateRouteFinished(List<RouteResult> routeResults,
                                                         RoutingError routingError) {
                        LoadingDialog.dismiss();

                        /* Calculation is done.Let's handle the result */
                        if (routingError == RoutingError.NONE) {
                            if (routeResults.get(0).getRoute() != null) {
                                /* Create a MapRoute so that it can be placed on the map */
                                m_mapRoute = new MapRoute(routeResults.get(0).getRoute());

                                /* Show the maneuver number on top of the route */
                                m_mapRoute.setManeuverNumberVisible(true);

                                /* Add the MapRoute to the map */
                                m_map.addMapObject(m_mapRoute);

                                /*
                                 * We may also want to make sure the map view is orientated properly
                                 * so the entire route can be easily seen.
                                 */
                                GeoBoundingBox gbb = routeResults.get(0).getRoute()
                                        .getBoundingBox();
                                m_map.zoomTo(gbb, Map.Animation.NONE,
                                        Map.MOVE_PRESERVE_ORIENTATION);
                            } else {
                                Toast.makeText(TripMapActivity.this,
                                        "Error:route results returned is not valid",
                                        Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(TripMapActivity.this,
                                    "Error:route calculation returned error code: " + routingError,
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        LoadingDialog.dispose();
        super.onDestroy();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
