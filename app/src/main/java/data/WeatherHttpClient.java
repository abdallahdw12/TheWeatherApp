package data;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Util.Utils;

public class WeatherHttpClient {
    public String getWeatherData(String place) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        try {
            connection = (HttpURLConnection) (new URL(Utils.BASE_URL + place+"&appid=63a9c2d71fcb9ba67930cfa4bf083b34")).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoInput(true);
            connection.connect();
            StringBuffer stringBuffer = new StringBuffer();
            inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line=bufferedReader.readLine())!=null){
                stringBuffer.append(line+"\r\n");
                Log.d("c", "ttt: "+stringBuffer.toString());


            }
            inputStream.close();
            connection.disconnect();
            return stringBuffer.toString();

        } catch (IOException e) {
            e.printStackTrace();

        }
return null;

    }
}
