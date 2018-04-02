package android.antitheft;

import android.content.Context;
import android.os.ServiceManager;
import android.util.Log;


public class AntiTheftManager {

    public static final String TAG = "AT_Manager";
    private static final String ANTI_THEFT_SERVICE_CLASS = "com.android.antitheft.AntiTheftService";
    private static AntiTheftManager sInstance;
    private static Context mContext;

    public static AntiTheftManager getInstance(Context context){
        if (sInstance == null) {
            sInstance = new AntiTheftManager(context);
        }

        return sInstance;
    }

    private AntiTheftManager(Context context) {
        mContext = context;
    }

    public void setValue(int val) {
        IAntiTheftService binder = IAntiTheftService.Stub.asInterface(
                ServiceManager.getService(ANTI_THEFT_SERVICE_CLASS));
        try {
            Log.d(TAG, "Going to call service");
            binder.setValue(20);
            Log.d(TAG, "Service called succesfully");
        }
        catch (Exception e) {
            Log.d(TAG, "FAILED to call service");
            e.printStackTrace();
        }
    }
}
