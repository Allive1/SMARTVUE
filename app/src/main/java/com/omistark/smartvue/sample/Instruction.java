package com.omistark.smartvue.sample;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;;

import java.io.IOException;
import java.io.InputStream;

public class Instruction {
    private static final String TAG = "Instruction";
    String jsonVal = "";
    int i = -1;
    JSONObject textSamples;
    public Instruction(Context applicationContext){
        try {
            jsonVal = loadJSONFromAsset(applicationContext);
            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            JSONObject jsonObject = new JSONObject(jsonVal);
            // A JSON array. JSONObject supports java.util.List interface.
            textSamples = (JSONObject) jsonObject.get("feature_samples");


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String loadJSONFromAsset(Context applicationContext) {
        String json = null;
        try {
            InputStream is = applicationContext.getAssets().open("samples/samples.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public String getSample(String featureName){
        JSONArray featureSamples;
        i++;
        Log.d(TAG, "Load create phase");
        try {
            featureSamples = (JSONArray) textSamples.get(featureName);
            jsonVal = featureSamples.getString(i);
            if(i >= featureSamples.length()){
                i = -1;
            }
        } catch (JSONException e){
            e.printStackTrace();
        }

        return jsonVal;
    }
}
