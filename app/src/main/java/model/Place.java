package model;

public class Place {
    private float lon;
    private float lat;
    private long sunrise;
    private long sunset;
    private String country;
    private String city;
    private long lastupdate;

    public Place() {

    }

    public Place(float lon, float lat, long sunrise, long sunset, String country, String city, long lastupdate) {
        this.lon = lon;
        this.lat = lat;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.country = country;
        this.city = city;
        this.lastupdate = lastupdate;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public String getCountry(String country) {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Place(String country) {
        this.country = country;
    }

    public long getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(long lastupdate) {
        this.lastupdate = lastupdate;
    }


}

