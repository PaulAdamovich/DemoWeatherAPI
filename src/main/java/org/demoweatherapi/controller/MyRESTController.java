package org.demoweatherapi.controller;

import org.demoweatherapi.excaption_hadling.IncorrectInputData;
import org.demoweatherapi.model.AverageWeather;
import org.demoweatherapi.model.DateRange;
import org.demoweatherapi.parse.Parsing;
import org.demoweatherapi.entity.CurrentWeather;
import org.demoweatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    public Parsing converting ;
    @Autowired
    public WeatherService weatherService;


    @GetMapping("/currentWeather")
    public CurrentWeather getCurrentWeather(){
        return converting.createCurrentWeatherFromJson();
    }

    @GetMapping("/averageWeather")
    public AverageWeather averageDailyInfo(@RequestBody DateRange date) {

       if(Pattern.matches("\\d{4}-\\d{2}-\\d{2}", date.getFrom()) &&
               Pattern.matches("\\d{4}-\\d{2}-\\d{2}", date.getTo())){

           return converting.createAverageWeatherFromJson(date.getFrom(), date.getTo());
       } else {
           throw new IncorrectInputData("You have the incorrect input format."
                   +" Please use pattern YYYY-MM-DD");
       }
    }
}
