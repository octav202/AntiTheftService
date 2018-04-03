package android.antitheft;

import android.content.Context;
import android.os.ServiceManager;
import android.util.Log;


public class AntiTheftManager {

    public static final String TAG = "AT_Manager";
    private static final String ANTI_THEFT_SERVICE_CLASS = "antitheft";
    private static AntiTheftManager sInstance;
    private static Context mContext;

    public static AntiTheftManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new AntiTheftManager(context);
        }

        return sInstance;
    }

    private AntiTheftManager(Context context) {
        mContext = context;
    }

    public void setValue(int val) {
        Log.d(TAG, "setValue() " + val);
        IAntiTheftService binder = IAntiTheftService.Stub.asInterface(
                ServiceManager.getService(ANTI_THEFT_SERVICE_CLASS));

        if (binder == null) {
            Log.d(TAG, "Error - Null Service");
            return;
        }
        try {
            binder.setValue(20);
            Log.d(TAG, "Service called succesfully");
        } catch (Exception e) {
            Log.d(TAG, "Exception: " + e.getLocalizedMessage());
        }
    }
}
