package easyroadtrip.com.ezroadtrip.Presentation.presenter.impl;

import android.widget.Toast;

import easyroadtrip.com.ezroadtrip.Data.datasource.hereapi.HereApiClient;
import easyroadtrip.com.ezroadtrip.Data.entity.PlaceResultEntity;
import easyroadtrip.com.ezroadtrip.Presentation.presenter.NewTripPresenter;
import easyroadtrip.com.ezroadtrip.Presentation.view.NewTripView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dora on 7/30/2017.
 */

public class NewTripPresenterImpl implements NewTripPresenter {

    private final String TAG = NewTripPresenterImpl.class.getName();

    NewTripView mNewTripView;

    public NewTripPresenterImpl(NewTripView newTripView) {
        mNewTripView = newTripView;
    }

    @Override
    public void displaySuggestedPlacesForOrigin(String query) {
        // TODO:
        HereApiClient.placeApi().requestSuggestedPlaces(query).enqueue(new Callback<PlaceResultEntity>() {
            @Override
            public void onResponse(Call<PlaceResultEntity> call, Response<PlaceResultEntity> response) {
                if (response.body().getPlaceEntityList() != null) {
                    mNewTripView.onLoadSuggestedPlacesInOrigin(response.body().getPlaceEntityList());
                }
            }

            @Override
            public void onFailure(Call<PlaceResultEntity> call, Throwable t) {
                mNewTripView.displayToast(t.getMessage(), Toast.LENGTH_SHORT);
            }
        });

    }

    @Override
    public void displaySuggestedPlacesForDestination(String query) {
        HereApiClient.placeApi().requestSuggestedPlaces(query).enqueue(new Callback<PlaceResultEntity>() {
            @Override
            public void onResponse(Call<PlaceResultEntity> call, Response<PlaceResultEntity> response) {
                if (response.body().getPlaceEntityList() != null) {
                    mNewTripView.onLoadSuggestedPlacesInDestination(response.body().getPlaceEntityList());
                }
            }

            @Override
            public void onFailure(Call<PlaceResultEntity> call, Throwable t) {
                mNewTripView.displayToast(t.getMessage(), Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    public void displayDatePickerDialog() {

    }

    @Override
    public void findTheRoute() {

    }
}
