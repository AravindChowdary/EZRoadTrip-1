package easyroadtrip.com.ezroadtrip.Presentation.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.here.android.mpa.search.DiscoveryResult;

import java.util.List;

/**
 * Created by Dora on 7/29/2017.
 */

public class RouteSuggestedAdapter extends ArrayAdapter<DiscoveryResult> {

    private List<DiscoveryResult> mDiscoveryResultList;

    public RouteSuggestedAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<DiscoveryResult> objects) {
        super(context, resource, objects);
        mDiscoveryResultList = objects;
    }

    @Override
    public int getCount() {
        return mDiscoveryResultList.size();
    }


}
