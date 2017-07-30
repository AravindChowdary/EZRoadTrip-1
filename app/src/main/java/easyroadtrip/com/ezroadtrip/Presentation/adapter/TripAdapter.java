package easyroadtrip.com.ezroadtrip.Presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import easyroadtrip.com.ezroadtrip.Domain.Trip;
import easyroadtrip.com.ezroadtrip.R;

/**
 * Created by Dora on 7/29/2017.
 */

public class TripAdapter extends BaseAdapter {

    private List<Trip> mTripList;

    public TripAdapter(List<Trip> tripList) {
        mTripList = tripList;
    }

    @Override
    public int getCount() {
        return mTripList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTripList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trip, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txtOriginDes = (TextView) convertView.findViewById(R.id.txtOriginDes);
            viewHolder.txtStartEndDate = (TextView) convertView.findViewById(R.id.txtStartEndDate);

            convertView.setTag(viewHolder);
        }

        if (viewHolder == null) {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Trip trip = mTripList.get(position);
        viewHolder.txtOriginDes.setText(trip.getOrigin() + " - " + trip.getDestionation());
        viewHolder.txtStartEndDate.setText(trip.getStartDate() + " - " + trip.getEndDate());

        return convertView;
    }

    public static class ViewHolder {
        TextView txtOriginDes;
        TextView txtStartEndDate;
    }
}
