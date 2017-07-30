package easyroadtrip.com.ezroadtrip.Presentation.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import easyroadtrip.com.ezroadtrip.Data.entity.SuggestedPlace;
import easyroadtrip.com.ezroadtrip.Domain.Trip;
import easyroadtrip.com.ezroadtrip.Presentation.Navigator.Navigator;
import easyroadtrip.com.ezroadtrip.Presentation.adapter.TripAdapter;
import easyroadtrip.com.ezroadtrip.Presentation.fragment.PlaceListFragment;
import easyroadtrip.com.ezroadtrip.R;

/**
 *  HomeActivity will display all trip that we have been planed so far.
 */
public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.fabNewTrip)
    FloatingActionButton mFabNewTrip;

    @BindView(R.id.txtNoTrip)
    TextView mTxtNoTrip;

    @BindView(R.id.lstTrip)
    ListView mLstTrip;

    TripAdapter mTripAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Your Planned Trip");

        // TODO: Init Views
        ButterKnife.bind(this);

        mFabNewTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                // TODO: Navigate to NewTripActivity
                Navigator.navigateToNewTripActivity(HomeActivity.this);
            }
        });

        // Load Data from JsonFile
        loadTripList();
    }

    public void loadTripList() {
        mTripAdapter = new TripAdapter(loadTripListFromJsonFile());
        mLstTrip.setAdapter(mTripAdapter);
        mLstTrip.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<SuggestedPlace> suggestedPlaceList = ((Trip)parent.getAdapter().getItem(position)).getSuggestedPlaceList();
                Navigator.navigateToTripMapActivity(HomeActivity.this, suggestedPlaceList);
            }
        });
    }

    public List<Trip> loadTripListFromJsonFile() {
        InputStream inputStream = getResources().openRawResource(R.raw.trip_list);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder result = new StringBuilder();
        try {
            String readLine;
            while((readLine = bufferedReader.readLine()) != null) {
                result.append(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Type type = new TypeToken<List<Trip>>(){}.getType();

        List<Trip> tripList = new Gson().fromJson(result.toString(), type);
        return tripList;
    }


}
