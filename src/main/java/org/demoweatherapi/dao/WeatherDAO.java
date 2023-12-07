package org.demoweatherapi.dao;

import jakarta.transaction.Transactional;
import org.demoweatherapi.entity.CurrentWeather;

public interface WeatherDAO {

    public void saveWeather(CurrentWeather weather);
}
