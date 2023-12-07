package org.demoweatherapi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.demoweatherapi.entity.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WeatherDAOImpl implements WeatherDAO{

    @Autowired
    public EntityManager entityManager;

    @Override
    public void saveWeather(CurrentWeather weather) {
       entityManager.merge(weather);
    }
}
