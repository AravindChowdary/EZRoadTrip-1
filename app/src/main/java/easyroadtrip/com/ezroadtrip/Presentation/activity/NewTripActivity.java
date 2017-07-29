package easyroadtrip.com.ezroadtrip.Presentation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import easyroadtrip.com.ezroadtrip.Presentation.Navigator.Navigator;
import easyroadtrip.com.ezroadtrip.Presentation.dialog.CustomDatePickerDialog;
import easyroadtrip.com.ezroadtrip.R;

public class NewTripActivity extends AppCompatActivity implements View.OnClickListener {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_trip);

        ButterKnife.bind(this);

        mBtnFindRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Navigate to RouteSuggestion Screen
                Navigator.navigageToRouteSuggestionActivity(NewTripActivity.this);
            }
        });
        mEdtStartDate.setOnClickListener(this);
        mEdtEndDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edtStartDate:case R.id.edtEndDate:
                showDatePickerDialog(v);
                break;
        }
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
}
