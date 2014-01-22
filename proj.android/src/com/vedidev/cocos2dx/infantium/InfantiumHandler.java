package com.vedidev.cocos2dx.infantium;

import android.util.Log;
import com.infantium.android.sdk.InfantiumAsyncResponseHandler;

/**
* @author vedi
*         date 1/14/14
*         time 10:08 AM
*/
class InfantiumHandler extends InfantiumAsyncResponseHandler {

    private static final String TAG = "Infantium";

    boolean connected = false;
    boolean hasPlayer = false;
    boolean failed = false;

    @Override
    public void onSuccessContentApp() {
        super.onSuccessContentApp();
        connected = true;
    }

    @Override
    public void onFailureContentApp(String description) {
        super.onFailureContentApp(description);
        failed = true;
        Log.w(TAG, "failureContentApp: " + description);
    }

    @Override
    public void onSuccessGetPlayerByUUID() {
        super.onSuccessGetPlayerByUUID();
        hasPlayer = true;
    }

    @Override
    public void onFailureGetPlayerByUUID(String description) {
        super.onFailureGetPlayerByUUID(description);
        failed = true;
        Log.w(TAG, "failureGetPlayerByUUID: " + description);
    }

    @Override
    public void onFailureCreateGameplay(String description) {
        super.onFailureCreateGameplay(description);
        Log.w(TAG, "failureCreateGameplay: " + description);
    }

    @Override
    public void onFailureGameRawdata(String description) {
        super.onFailureGameRawdata(description);
        Log.w(TAG, "failureGameRawdata: " + description);
    }

    @Override
    public void onFailureCloseGameplay(String description) {
        super.onFailureCloseGameplay(description);
        Log.w(TAG, "failureCloseGameplay: " + description);
    }

    public boolean isReady() {
        return !failed && connected && hasPlayer;
    }
}
