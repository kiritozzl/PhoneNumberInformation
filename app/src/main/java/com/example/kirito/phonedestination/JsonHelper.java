package com.example.kirito.phonedestination;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kirito on 2016.10.06.
 */

public class JsonHelper {

    public static Item parseJsonToItem(String json){
        Item item = new Item();
        try {
            JSONObject object = new JSONObject(json);
            JSONObject result = object.getJSONObject("result");
            if (result != null){
                item.setProvince(result.getString("province"));
                item.setAreacode(result.getString("areacode"));
                item.setCity(result.getString("city"));
                item.setCompany(result.getString("company"));
                item.setCard(result.getString("card"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return item;
    }
}
