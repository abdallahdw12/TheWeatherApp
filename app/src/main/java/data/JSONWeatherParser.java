package data;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Util.Utils;
import model.Place;
import model.Weather;

public class JSONWeatherParser {
    public static Weather getWeather(String data) {

        Log.d("ttt", "getWeather:data"+data);

        Weather weather = new Weather();
        try {
            JSONObject jsonObject = new JSONObject(data);
            Place place = new Place();
            JSONObject coorObj = Utils.getobject("coord", jsonObject);
            place.setLat(Utils.getFloat("lat", coorObj));
            place.setLon(Utils.getFloat("lon", coorObj));
            JSONObject sysObj = Utils.getobject("sys", jsonObject);
            place.setCountry(Utils.getString("country", sysObj));
            place.setLastupdate(Utils.getInt("dt", jsonObject));
            place.setSunrise(Utils.getInt("sunrise", sysObj));
            place.setSunset(Utils.getInt("sunset", sysObj));
            place.setCity(Utils.getString("name", jsonObject));
            weather.place = place;
            JSONArray jsonArray = jsonObject.getJSONArray("weather");
            JSONObject jsonWeather = jsonArray.getJSONObject(0);
            weather.currentCondition.setWeatherid(Utils.getInt("id", jsonWeather));
            weather.currentCondition.setDescription(Utils.getString("description", jsonWeather));
            weather.currentCondition.setCondition(Utils.getInt("main", jsonWeather));
            weather.currentCondition.setIcon(Utils.getString("icon", jsonWeather));
            JSONObject windObj = Utils.getobject("wind", jsonObject);
            weather.wind.setSpeed(Utils.getFloat("speed", windObj));
            weather.wind.setDeg(Utils.getFloat("deg", windObj));
            JSONObject cloudObj = Utils.getobject("colds", jsonObject);
            weather.clouds.setPrecipitation(Utils.getInt("all", cloudObj));
            return weather;


        } catch (JSONException e) {
            e.printStackTrace();
return null;
        }
    }
}
