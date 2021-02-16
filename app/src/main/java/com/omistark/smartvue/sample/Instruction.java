package com.omistark.smartvue.sample;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Instruction {
//    JSONParser parser = new JSONParser();
    String jsonVal = "";
    public Instruction(Context applicationContext){
//        parser = new JSONParser();
//        try {
//            Object obj = parser.parse(new FileReader("assets/samples/samples.json"));
//
//            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
//            JSONObject jsonObject = (JSONObject) obj;
//
//            // A JSON array. JSONObject supports java.util.List interface.
//            JSONArray companyList = (JSONArray) jsonObject.get("Company List");
//
//            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
//            // Iterators differ from enumerations in two ways:
//            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
//            // 2. Method names have been improved.
//            Iterator<JSONObject> iterator = companyList.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }
//        }catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        jsonVal = loadJSONFromAsset(applicationContext);
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

    public String getSample(){
        return jsonVal;
    }
}
