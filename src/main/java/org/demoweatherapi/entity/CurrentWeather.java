package org.demoweatherapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "weather")
public class CurrentWeather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;
    @Column(name = "temperature")
    private double temperature;
    @Column(name = "wind_speed")
    private double windSpeedMH; //метров в час
    @Column(name = "air_pressure")
    private double airPressureMB;
    @Column(name = "air_humidity")
    private long airHumidity; //влажность воздуха
    @Column(name = "weather_condition")
    private String weatherCondition;
    @Column(name = "location")
    private String location;

    public CurrentWeather() {
    }

    public CurrentWeather(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeedMH() {
        return windSpeedMH;
    }

    public void setWindSpeedMH(double windSpeedMH) {
        this.windSpeedMH = windSpeedMH;
    }

    public double getAirPressureMB() {
        return airPressureMB;
    }

    public void setAirPressureMB(double airPressureMB) {
        this.airPressureMB = airPressureMB;
    }

    public long getAirHumidity() {
        return airHumidity;
    }

    public void setAirHumidity(long airHumidity) {
        this.airHumidity = airHumidity;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "ib=" + id +
                ", temperature=" + temperature +
                ", windSpeedMH=" + windSpeedMH +
                ", airPressureMB=" + airPressureMB +
                ", airHumidity=" + airHumidity +
                ", weatherCondition='" + weatherCondition + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}