package easyroadtrip.com.ezroadtrip.Presentation.view;

import java.util.List;

import easyroadtrip.com.ezroadtrip.Data.entity.PlaceEntity;

/**
 * Created by Dora on 7/30/2017.
 */

public interface NewTripView extends BaseView {

    public void onLoadSuggestedPlacesInOrigin(List<PlaceEntity> placeEntityList);
    public void onLoadSuggestedPlacesInDestination(List<PlaceEntity> placeEntityList);

}
