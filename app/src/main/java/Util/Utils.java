package Util;

import org.json.JSONException;
import org.json.JSONObject;

public class Utils {
    public static final String BASE_URL="=https://api.openweathermap.org/data/2.5/weather?id=2172797&appid=63a9c2d71fcb9ba67930cfa4bf083b34\n";
    public static final String ICON="https://png.icons8.com/search/2266EE";
    public static JSONObject getobject (String tagName,JSONObject jsonObject)throws JSONException{
        JSONObject jObj= jsonObject.getJSONObject(tagName);
        return jObj;
    }
    public static String getString (String tagName,JSONObject jsonObject)throws  JSONException{
        return jsonObject.getString(tagName);

    }
public static float getFloat(String tagNmae, JSONObject jsonObject)throws JSONException{
        return(float)jsonObject.getDouble(tagNmae);

}
public static double getDoble(String tagName, JSONObject jsonObject)throws JSONException{
        return (float)jsonObject.getDouble(tagName);

}
public static int getInt(String tagName,JSONObject jsonObject)throws  JSONException{
        return jsonObject.getInt(tagName);

}
}
