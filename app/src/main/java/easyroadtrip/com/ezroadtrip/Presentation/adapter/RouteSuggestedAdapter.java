package easyroadtrip.com.ezroadtrip.Presentation.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.here.android.mpa.routing.RouteResult;

import java.util.List;

/**
 * Created by Dora on 7/29/2017.
 */

public class RouteSuggestedAdapter extends BaseAdapter {

    private List<RouteResult> mRouteResultList;

    public RouteSuggestedAdapter(List<RouteResult> routeResultList) {
        mRouteResultList = routeResultList;
    }

    @Override
    public int getCount() {
        return mRouteResultList.size();
    }

    @Override
    public RouteResult getItem(int position) {
        return mRouteResultList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }
}
