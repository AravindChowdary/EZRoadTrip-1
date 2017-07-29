package easyroadtrip.com.ezroadtrip.Presentation.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import easyroadtrip.com.ezroadtrip.Presentation.Navigator.Navigator;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

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

    }

}
