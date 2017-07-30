package easyroadtrip.com.ezroadtrip.Presentation.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.here.android.mpa.search.PlaceLink;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import easyroadtrip.com.ezroadtrip.Data.entity.SuggestedPlace;
import easyroadtrip.com.ezroadtrip.Presentation.adapter.PlaceExpandableAdapter;
import easyroadtrip.com.ezroadtrip.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlaceListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PlaceListFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private List<SuggestedPlace> mSuggestedPlaces;

    @BindView(R.id.lstPlace)
    ExpandableListView mLstPlace;

    public PlaceListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_place_list, container, false);
        ButterKnife.bind(this, view);

        PlaceExpandableAdapter adapter = new PlaceExpandableAdapter(getContext(), mSuggestedPlaces);
        mLstPlace.setAdapter(adapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setSuggestedPlaces(List<SuggestedPlace> suggestedPlaceList) {
        mSuggestedPlaces = suggestedPlaceList;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
