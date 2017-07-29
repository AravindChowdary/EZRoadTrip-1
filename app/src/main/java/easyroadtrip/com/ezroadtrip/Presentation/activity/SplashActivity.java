package easyroadtrip.com.ezroadtrip.Presentation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import easyroadtrip.com.ezroadtrip.Data.datasource.network.RestClient;
import easyroadtrip.com.ezroadtrip.Presentation.Navigator.Navigator;
import easyroadtrip.com.ezroadtrip.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    private final String TAG = SplashActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO: Navigate to HomeActivity
                        Navigator.navigateToHomeActivity(SplashActivity.this);
                    }
                });
            }
        };
        timer.schedule(timerTask, 1000);
    }
}
