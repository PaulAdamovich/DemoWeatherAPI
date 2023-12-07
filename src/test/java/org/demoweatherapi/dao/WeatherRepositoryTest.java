package org.demoweatherapi.dao;

import org.demoweatherapi.DemoWeatherApiApplication;
import org.demoweatherapi.entity.CurrentWeather;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoWeatherApiApplication.class)
public class WeatherRepositoryTest {

    private static final long ID = 1L;

    @Autowired
    private WeatherRepository repository ;

    @Test
    public void saveWeather_shouldSaveWeather_whenCalledOnetime(){
        CurrentWeather currentWeather = new CurrentWeather(ID);

        repository.save(currentWeather);
        boolean isNotEmpty = repository.existsById(ID);

        assertTrue(isNotEmpty);
    }
}