package com.vedidev.cocos2dx.infantium;

import com.easyndk.AndroidNDKHelper;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author vedi
 *         date 7/1/13
 *         time 11:40 PM
 */
public class InfantiumBridge {

    public static JSONObject dispatchNDKCall(JSONObject params) {
        JSONObject retParams = new JSONObject();
        try {
            String methodName = params.getString("method");
            if (methodName.equals("init")) {
                String apiUser = params.getString("apiUser");
                String apiKey = params.getString("apiKey");
                String contentAppUuid = params.getString("contentAppUuid");
                InfantiumManager.init(apiUser, apiKey, contentAppUuid);
            } else if (methodName.equals("createGameplay")) {
                String subContentUuid = params.getString("subContentUuid");
                InfantiumManager.createGameplay(subContentUuid);
            } else if (methodName.equals("startPlaying")) {
                InfantiumManager.startPlaying();
            } else if (methodName.equals("setSuccesses")) {
                int successes = params.getInt("successes");
                InfantiumManager.setSuccesses(successes);
            } else if (methodName.equals("setFailures")) {
                int failures = params.getInt("failures");
                InfantiumManager.setFailures(failures);
            } else if (methodName.equals("sendGameRawData")) {
                InfantiumManager.sendGameRawData();
            } else if (methodName.equals("closeGameplay")) {
                InfantiumManager.closeGameplay();
            } else {
                throw new UnsupportedOperationException();
            }
        } catch (JSONException e) {
            throw new IllegalArgumentException(e);
        }

        return retParams;
    }

    public static void dispatchNDKCallback(String key, JSONObject parameters) {
        AndroidNDKHelper.sendMessageWithParameters(key, parameters);
    }
}
