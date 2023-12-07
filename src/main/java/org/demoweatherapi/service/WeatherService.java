package org.demoweatherapi.service;

import org.demoweatherapi.entity.CurrentWeather;

public interface WeatherService {
    void saveWeather(CurrentWeather currentWeather);
    CurrentWeather getWeather(long id);
}
