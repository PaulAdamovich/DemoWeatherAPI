package org.demoweatherapi.service;

import jakarta.transaction.Transactional;
import org.demoweatherapi.dao.WeatherDAO;
import org.demoweatherapi.entity.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherDAO weatherDAO;

    @Override
    @Transactional
    public void saveWeather(CurrentWeather currentWeather) {
     weatherDAO.saveWeather(currentWeather);

    }
}
