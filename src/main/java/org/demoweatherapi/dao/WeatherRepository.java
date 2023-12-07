package org.demoweatherapi.dao;

import org.demoweatherapi.entity.CurrentWeather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<CurrentWeather, Long> {
}
