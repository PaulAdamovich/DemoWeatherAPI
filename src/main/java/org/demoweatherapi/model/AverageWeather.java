package org.demoweatherapi.model;

import com.fasterxml.jackson.annotation.JsonGetter;

public class AverageWeather {

    private double temperature;
    private double windSpeedMH;
    private double airPressureMB;
    private long airHumidity;
    private String location;

    public AverageWeather() {
    }
    @JsonGetter("average_temperature")
    public double getTemperature() {
        String result = String.format("%8.2f", temperature).replace(',', '.');
        return Double.parseDouble(result);
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    @JsonGetter("average_wind_speed_mh")
    public double getWindSpeedMH() {
        String result = String.format("%8.2f", windSpeedMH).replace(',', '.');
        return Double.parseDouble(result);
    }

    public void setWindSpeedMH(double windSpeedMH) {
        this.windSpeedMH = windSpeedMH;
    }
    @JsonGetter("average_air_pressure")
    public double getAirPressureMB() {
        String result = String.format("%8.2f", airPressureMB).replace(',', '.');
        return Double.parseDouble((result));
    }

    public void setAirPressureMB(double airPressureMB) {
        this.airPressureMB = airPressureMB;
    }
    @JsonGetter("average_air_humidity")
    public long getAirHumidity() {
        return airHumidity;
    }

    public void setAirHumidity(long airHumidity) {
        this.airHumidity = airHumidity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "AverageWeather{" +
                "temperature=" + temperature +
                ", windSpeedMH=" + windSpeedMH +
                ", airPressureMB=" + airPressureMB +
                ", airHumidity=" + airHumidity +
                ", location='" + location + '\'' +
                '}';
    }
}
