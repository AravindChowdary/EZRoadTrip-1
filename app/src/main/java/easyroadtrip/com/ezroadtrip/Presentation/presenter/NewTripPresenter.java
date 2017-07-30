package easyroadtrip.com.ezroadtrip.Presentation.presenter;

/**
 * Created by Dora on 7/30/2017.
 */

public interface NewTripPresenter {

    void displaySuggestedPlacesForOrigin(String query);
    void displaySuggestedPlacesForDestination(String query);
    void displayDatePickerDialog();
    void findTheRoute();

}
