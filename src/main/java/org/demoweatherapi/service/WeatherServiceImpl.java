package org.demoweatherapi.service;

import org.demoweatherapi.dao.WeatherRepository;
import org.demoweatherapi.entity.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public void saveWeather(CurrentWeather currentWeather) {
     weatherRepository.save(currentWeather);
    }

    //Method special for WeatherRepositoryTest
    @Override
    public CurrentWeather getWeather(long id){
        CurrentWeather currentWeather= null;
        Optional<CurrentWeather> optional = weatherRepository.findById(id);
        if (optional.isPresent()){
            currentWeather = optional.get();
        } else {
            throw new NullPointerException("Object with this ID does not exist");
        }
        return currentWeather;
    }
}
