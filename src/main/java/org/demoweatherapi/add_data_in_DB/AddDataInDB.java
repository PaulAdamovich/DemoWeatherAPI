package org.demoweatherapi.add_data_in_DB;

import org.demoweatherapi.parse.Parsing;
import org.demoweatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AddDataInDB {

    @Autowired
    public Parsing converting ;
    @Autowired
    public WeatherService weatherService ;
    @Scheduled(fixedRateString = "${fixed.rates}" )
    public void addCurrentWeatherInDB(){
        weatherService.saveWeather(converting.createCurrentWeatherFromJson());
    }
}
