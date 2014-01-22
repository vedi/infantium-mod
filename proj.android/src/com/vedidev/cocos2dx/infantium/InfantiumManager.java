package com.vedidev.cocos2dx.infantium;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.Display;
import com.infantium.android.sdk.Infantium_SDK;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

/**
 * @author vedi
 *         date 7/1/13
 *         time 11:44 PM
 */
public class InfantiumManager {

    private static final String TAG = "Infantium";

    private static WeakReference<Activity> ACTIVITY_WEAK_REFERENCE = new WeakReference<Activity>(null);
    private static Infantium_SDK infantium = null;
    private static InfantiumHandler infantiumHandler;

    public static void initModule(Activity activity) {
        ACTIVITY_WEAK_REFERENCE = new WeakReference<Activity>(activity);
        infantium = Infantium_SDK.getInfantium_SDK(activity.getBaseContext());
        infantiumHandler = new InfantiumHandler();
    }

    public static void init(String apiUser, String apiKey, String contentAppUuid) {
        Activity activity = ACTIVITY_WEAK_REFERENCE.get();
        if (activity == null) {
            throw new IllegalStateException("Module Infantium is not initialized");
        }
        //  infantium
        Display display = activity.getWindowManager().getDefaultDisplay();

        int width = display.getWidth();
        int height = display.getHeight();

        infantium.setDeveloperCredentials(apiUser, apiKey);
        infantium.setDeviceInfo(width, height);
        infantium.setDeveloperHandler(infantiumHandler);
        infantium.setContentAppUUID(contentAppUuid);
    }

    public static void createGameplay(String subContentUuid) {
        if (infantiumHandler.isReady()) {
            infantium.createGameplay(subContentUuid);
        } else {
            Log.w(TAG, "Infantium is not ready. The call is refused");
        }
    }

    public static void startPlaying() {
        if (infantiumHandler.isReady()) {
            infantium.startPlaying();
        } else {
            Log.w(TAG, "Infantium is not ready. The call is refused");
        }
    }

    public static void setSuccesses(int successes) {
        if (infantiumHandler.isReady()) {
            infantium.setSuccesses(successes);
        } else {
            Log.w(TAG, "Infantium is not ready. The call is refused");
        }
    }

    public static void setFailures(int failures) {
        if (infantiumHandler.isReady()) {
            infantium.setFailures(failures);
        } else {
            Log.w(TAG, "Infantium is not ready. The call is refused");
        }
    }

    public static void sendGameRawData() {
        if (infantiumHandler.isReady()) {
            infantium.sendGameRawData();
        } else {
            Log.w(TAG, "Infantium is not ready. The call is refused");
        }
    }

    public static void closeGameplay() {
        if (infantiumHandler.isReady()) {
            infantium.closeGameplay();
        } else {
            Log.w(TAG, "Infantium is not ready. The call is refused");
        }
    }

    public static void onPause() {
        infantium.onPauseInfantium();
    }

    public static void onResume() {
        infantium.onResumeInfantium();
    }
}
