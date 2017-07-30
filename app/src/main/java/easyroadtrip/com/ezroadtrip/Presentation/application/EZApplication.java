package easyroadtrip.com.ezroadtrip.Presentation.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by Dora on 7/30/2017.
 */

public class EZApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
