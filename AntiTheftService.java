package android.antitheft;

import android.content.Context;
import android.util.Log;

public class AntiTheftService extends IAntiTheftService.Stub {
    private Context mContext;
    public static final String TAG = "AT_Service";

    public AntiTheftService(Context context) {
        super();
        mContext = context;

        Log.i(TAG, "Spawned worker thread");
    }

    public void setValue(int val) {
        Log.i(TAG, "setValue " + val);
    }

}