package easyroadtrip.com.ezroadtrip.Presentation.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import easyroadtrip.com.ezroadtrip.Data.datasource.database.DatabaseHelper;
import easyroadtrip.com.ezroadtrip.Data.datasource.network.RestClient;
import easyroadtrip.com.ezroadtrip.Presentation.Navigator.Navigator;
import easyroadtrip.com.ezroadtrip.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends BaseActivity {

    private final String TAG = SplashActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // TODO: Generate Database
        DatabaseHelper.getInstance(getApplicationContext());
    }

    @Override
    protected void onStart() {
        super.onStart();

        //TODO: Check Permissions
        //requestPermission();

        //TODO: Delay display loading list
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO: Navigate to HomeActivity
                        //Navigator.navigateToHomeActivity(SplashActivity.this);
                    }
                });
            }
        };
        timer.schedule(timerTask, 1000);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Navigator.navigateToHomeActivity(SplashActivity.this);
    }
}
