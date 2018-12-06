package com.example.abdallahdwikat.theweatherapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import data.JSONWeatherParser;
import data.WeatherHttpClient;
import model.Weather;

public class MainActivity extends AppCompatActivity {
    private TextView cityName;
    private TextView temp;
    private ImageView iconView;
    private TextView description;
    private TextView humidity;
    private TextView pressure;
    private TextView wind;
    private TextView sunrise;
    private TextView sunset;
    private TextView updated;

    Weather weather = new Weather();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityName = (TextView) findViewById(R.id.CityText);
        temp = (TextView) findViewById(R.id.tempText);
        iconView = (ImageView) findViewById(R.id.ThumbnailIcon);
        description = (TextView) findViewById(R.id.RainText);
        humidity = (TextView) findViewById(R.id.HumidText);
        pressure = (TextView) findViewById(R.id.PressureText);
        wind = (TextView) findViewById(R.id.WindText);
        sunrise = (TextView) findViewById(R.id.RiseText);
        sunset = (TextView) findViewById(R.id.SetText);
        updated = (TextView) findViewById(R.id.UpdateText);

        renderWeatherData("Parma,Italy");
    }

    public void renderWeatherData(String city) {
        WeatherTask weatherTask = new WeatherTask();
        weatherTask.execute(new String[]{city + "&units=metric"});

    }

    private class WeatherTask extends AsyncTask<String, Void, Weather> {
        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);
            cityName.setText(weather.place.getCity() + "," + weather.place.getCity());
            temp.setText("" + weather.currentCondition.getTemprature() + "C");

        }

        @Override
        protected Weather doInBackground(String... params) {
            String data = ((new WeatherHttpClient()).getWeatherData(params[0]));
            weather = JSONWeatherParser.getWeather(data);
            Log.v("data", weather.currentCondition.getDescription());

            return weather;
        }
    }
}
