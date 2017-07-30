package easyroadtrip.com.ezroadtrip.Presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import easyroadtrip.com.ezroadtrip.Data.entity.SuggestedPlace;
import easyroadtrip.com.ezroadtrip.R;

/**
 * Created by Dora on 7/30/2017.
 */

public class PlaceExpandableAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<SuggestedPlace> mSuggestedPlaceList;

    public PlaceExpandableAdapter(Context context, List<SuggestedPlace> suggestedPlaceList) {
        mContext = context;
        mSuggestedPlaceList = suggestedPlaceList;
    }

    @Override
    public int getGroupCount() {
        return mSuggestedPlaceList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public SuggestedPlace getGroup(int groupPosition) {
        return mSuggestedPlaceList.get(groupPosition);
    }

    @Override
    public SuggestedPlace getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place_group, parent, false);
        }

        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
        TextView txtAddress = (TextView) convertView.findViewById(R.id.txtAddress);
        TextView txtDuration = (TextView) convertView.findViewById(R.id.txtDuration);

        txtTitle.setText(mSuggestedPlaceList.get(groupPosition).getTitle());
        txtAddress.setText(mSuggestedPlaceList.get(groupPosition).getAddress() + "");
        txtDuration.setText(mSuggestedPlaceList.get(groupPosition).getDuration() + "");

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place, parent, false);
        }

        TextView txtFee = (TextView) convertView.findViewById(R.id.txtFee);
        TextView txtRating = (TextView) convertView.findViewById(R.id.txtRating);
        TextView txtThingsToDo = (TextView) convertView.findViewById(R.id.txtThingsToDo);

        txtFee.setText(mSuggestedPlaceList.get(groupPosition).getFee());
        txtRating.setText(mSuggestedPlaceList.get(groupPosition).getRating() + "");
        txtThingsToDo.setText(mSuggestedPlaceList.get(groupPosition).getThingsToDo() + "");

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
