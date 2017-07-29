package easyroadtrip.com.ezroadtrip.Presentation.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by Dora on 7/29/2017.
 */

public class CustomDatePickerDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    private DatePickerDialogListener mListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        if (mListener == null) {
            throw new NullPointerException("View must implement DatePickerDialogListener!");
        }
        mListener.onDateSelected(year + "-" + month + "-" + dayOfMonth);
    }

    public void setDatePickerDialogListener(DatePickerDialogListener listener) {
        this.mListener = listener;
    }

    public interface DatePickerDialogListener {
        void onDateSelected(String date);
    }
}
