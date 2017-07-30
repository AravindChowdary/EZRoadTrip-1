package easyroadtrip.com.ezroadtrip.Presentation.dialog;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by Dora on 7/30/2017.
 */

public class LoadingDialog {

    private static ProgressDialog progressDialog = null;

    public static void show(Activity activity, String message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(activity);
            progressDialog.setIndeterminate(false);
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public static void dismiss() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public static void dispose() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog = null;
    }

}
