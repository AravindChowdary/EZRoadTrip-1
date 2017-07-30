package easyroadtrip.com.ezroadtrip.Presentation.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


import java.util.List;

import easyroadtrip.com.ezroadtrip.Data.entity.PlaceEntity;
import easyroadtrip.com.ezroadtrip.R;

/**
 * Created by Dora on 7/29/2017.
 */

public class PlaceSuggestedAdapter extends ArrayAdapter<PlaceEntity> implements Filterable {

    private List<PlaceEntity> mPlaceEntityList;
    private Context mContext;

    public PlaceSuggestedAdapter(@NonNull Context context, @LayoutRes int resource,
                                 @NonNull List<PlaceEntity> objects) {
        super(context, resource, objects);
        mContext = context;
        mPlaceEntityList = objects;
    }

    @Override
    public int getCount() {
        return mPlaceEntityList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        PlaceEntity PlaceEntity = mPlaceEntityList.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_place_suggested, parent, false);
        }

        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
        TextView txtVicinity = (TextView) convertView.findViewById(R.id.txtVicinity);

        txtTitle.setText(PlaceEntity.getTitle());
        if (PlaceEntity.getVicinity() != null) {
            String vicinity = PlaceEntity.getVicinity().replaceAll("<(.*?)\\>"," ");//Removes all items in brackets
            vicinity = vicinity.replaceAll("<(.*?)\\\n"," ");//Must be undeneath
            vicinity = vicinity.replaceFirst("(.*?)\\>", " ");//Removes any connected item to the last bracket
            vicinity = vicinity.replaceAll("&nbsp;"," ");
            vicinity = vicinity.replaceAll("&amp;"," ");

            txtVicinity.setText(Html.fromHtml(vicinity));
        }

        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    List<PlaceEntity> books = findBooks(mContext, constraint.toString());

                    // Assign the data to the FilterResults
                    filterResults.values = books;
                    filterResults.count = books.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    mPlaceEntityList = (List<PlaceEntity>) results.values;
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }};
        return filter;
    }

    /**
     * Returns a search result for the given book title.
     */
    private List<PlaceEntity> findBooks(Context context, String placeSearch) {
        return mPlaceEntityList;
    }
}
