package easyroadtrip.com.ezroadtrip.Presentation.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import easyroadtrip.com.ezroadtrip.Data.entity.PlaceEntity;
import easyroadtrip.com.ezroadtrip.Presentation.Navigator.Navigator;
import easyroadtrip.com.ezroadtrip.Presentation.adapter.PlaceSuggestedAdapter;
import easyroadtrip.com.ezroadtrip.Presentation.dialog.CustomDatePickerDialog;
import easyroadtrip.com.ezroadtrip.Presentation.presenter.NewTripPresenter;
import easyroadtrip.com.ezroadtrip.Presentation.presenter.impl.NewTripPresenterImpl;
import easyroadtrip.com.ezroadtrip.Presentation.view.NewTripView;
import easyroadtrip.com.ezroadtrip.R;

public class NewTripActivity extends BaseActivity implements View.OnClickListener, NewTripView{

    private final String TAG = NewTripActivity.class.getName();

    @BindView(R.id.txtAutoOrigin)
    AutoCompleteTextView mTxtAutoOrigin;

    @BindView(R.id.txtAutoDestination)
    AutoCompleteTextView mTxtAutoDestination;

    @BindView(R.id.edtStartDate)
    EditText mEdtStartDate;

    @BindView(R.id.edtEndDate)
    EditText mEdtEndDate;

    @BindView(R.id.btnFindRoute)
    Button mBtnFindRoute;

    NewTripPresenter mNewTripPresenter;

    PlaceSuggestedAdapter mOriginPlaceAdapter;
    PlaceSuggestedAdapter mDestinationPlaceAdapter;

    private double startLat;
    private double startLon;
    private double endLat;
    private double endLon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trip);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("New Trip");

        ButterKnife.bind(this);

        mEdtStartDate.setOnClickListener(this);
        mEdtEndDate.setOnClickListener(this);

        // TODO: Initialize NewTripPresenter
        mNewTripPresenter = new NewTripPresenterImpl(this);

        // TODO: Add TextChangeListener to AutocompleteTextview
        addTextChangeListener();

        mBtnFindRoute.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edtStartDate:case R.id.edtEndDate:
                showDatePickerDialog(v);
                break;
            case R.id.btnFindRoute:
                // TODO: Hide Hide soft keyboard
                // Source : https://stackoverflow.com/questions/1109022/close-hide-the-android-soft-keyboard
                View view = this.getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }

                // TODO: Navigate to Suggested Routes Activity
                Navigator.navigageToTripMapActivity(this, startLat, startLon, endLat, endLon);
                break;
        }
    }

    @Override
    public void onLoadSuggestedPlacesInOrigin(List<PlaceEntity> placeEntityList) {
        mOriginPlaceAdapter = new PlaceSuggestedAdapter(getApplicationContext(), R.layout.item_place_suggested, placeEntityList);
        mTxtAutoOrigin.setAdapter(mOriginPlaceAdapter);
    }

    @Override
    public void onLoadSuggestedPlacesInDestination(List<PlaceEntity> placeEntityList) {
        mDestinationPlaceAdapter = new PlaceSuggestedAdapter(getApplicationContext(), R.layout.item_place_suggested, placeEntityList);
        mTxtAutoDestination.setAdapter(mDestinationPlaceAdapter);
    }

    @Override
    public void displayToast(String message, int duration) {
        Toast.makeText(this, message, duration);
    }

    public void showDatePickerDialog(final View view) {
        CustomDatePickerDialog datePickerDialog = new CustomDatePickerDialog();
        datePickerDialog.setDatePickerDialogListener(new CustomDatePickerDialog.DatePickerDialogListener() {
            @Override
            public void onDateSelected(String date) {
                ((EditText)view).setText(date);
            }
        });
        datePickerDialog.show(getSupportFragmentManager(), null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addTextChangeListener() {

        mTxtAutoOrigin.addTextChangedListener(new TextWatcher() {
            private boolean shouldAutoComplete = false;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                shouldAutoComplete = true;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (shouldAutoComplete) {
                    mNewTripPresenter.displaySuggestedPlacesForOrigin(s.toString());
                }
            }
        });


        mTxtAutoDestination.addTextChangedListener(new TextWatcher() {
            private boolean shouldAutoComplete = false;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                shouldAutoComplete = true;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (shouldAutoComplete) {
                    mNewTripPresenter.displaySuggestedPlacesForDestination(s.toString());
                }
            }
        });

        mTxtAutoOrigin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PlaceEntity placeEntity = (PlaceEntity) parent.getAdapter().getItem(position);
                startLat = placeEntity.getPositions()[0];
                startLon = placeEntity.getPositions()[1];
            }
        });

        mTxtAutoDestination.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PlaceEntity placeEntity = (PlaceEntity) parent.getAdapter().getItem(position);
                endLat = placeEntity.getPositions()[0];
                endLon = placeEntity.getPositions()[1];
            }
        });
    }


}
