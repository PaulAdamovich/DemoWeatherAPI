package org.demoweatherapi.parse;

import org.demoweatherapi.communicate_third_API.Communicate;
import org.demoweatherapi.excaption_handling.ImpossibleParseResponse;
import org.demoweatherapi.excaption_handling.IncorrectInputData;
import org.demoweatherapi.model.AverageWeather;
import org.demoweatherapi.entity.CurrentWeather;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Iterator;

@Component
public class Parsing {

    @Autowired
    public Communicate communicate;

    public CurrentWeather createCurrentWeatherFromJson() {

        String json = communicate.getWeatherRealTime();
        CurrentWeather weather = new CurrentWeather();
        Object obj = null;
        try {
            obj = new JSONParser().parse(json);
        } catch (ParseException e) {
            throw new ImpossibleParseResponse(e.getMessage());
        }
        JSONObject jo = (JSONObject) obj;
        return parsingForCurrentWeather(weather, jo);
    }

    public AverageWeather createAverageWeatherFromJson(String from, String to) {

        String json = communicate.getAverageWeather(from, to);
        AverageWeather weather = new AverageWeather();
        Object obj = null;
        try {
            obj = new JSONParser().parse(json);
        } catch (ParseException e) {
            throw new ImpossibleParseResponse(e.getMessage());
        }
        JSONObject jo = (JSONObject) obj;
        return parsingForAverageWeather(weather, jo);
    }

    public CurrentWeather parsingForCurrentWeather(CurrentWeather weather, JSONObject jo){
        JSONObject location = (JSONObject) jo.get("location");
        weather.setLocation((String) location.get("tz_id"));

        JSONObject current = (JSONObject) jo.get("current");
        weather.setTemperature((Double) current.get("temp_c"));
        weather.setAirHumidity((Long) current.get("humidity"));
        weather.setAirPressureMB((Double) current.get("pressure_mb"));
        weather.setWindSpeedMH((Double) current.get("wind_kph")*1000);//parsing from km/h in m/h

        JSONObject condition = (JSONObject) current.get("condition");
        weather.setWeatherCondition((String) condition.get("text"));

        return weather;
    }

    public AverageWeather parsingForAverageWeather(AverageWeather weather, JSONObject jo){
        JSONObject location = (JSONObject) jo.get("location");
        if(location == null){
            JSONObject error = (JSONObject) jo.get("error");
            String message = (String) error.get("message");
            throw new IncorrectInputData("Message from WeatherAPI.com: "+message+
                    " Recommendation: Date range should not exceed 9 days from current date");
        }
        weather.setLocation((String) location.get("tz_id"));

        JSONObject forecast = (JSONObject) jo.get("forecast");
        JSONArray arrayForecastDay = (JSONArray) forecast.get("forecastday");

        Iterator iteratorByDay = arrayForecastDay.iterator();
        int numberOfDays = 0;
        double temperature = 0.0;
        double airHumidity = 0.0;
        double windSpeed = 0.0;
        double airPressure = 0.0;
        //Iterate by days
        while(iteratorByDay.hasNext()){
            numberOfDays++;
            JSONObject date=(JSONObject) iteratorByDay.next();
            JSONObject day=(JSONObject) date.get("day");
            temperature+=((Double) day.get("avgtemp_c"));
            airHumidity+=((Double) day.get("avghumidity"));
            JSONArray hourArray = (JSONArray) date.get("hour");
            //Iterate by hours
            for (Object o : hourArray) {
                JSONObject currentHour = (JSONObject) o;
                windSpeed += (Double) currentHour.get("wind_kph") * 1000;//Converting km/h to m/h
                airPressure += (Double) currentHour.get("pressure_mb");
            }
        }
        //Calculate the average value
        weather.setTemperature(temperature/numberOfDays);
        weather.setAirHumidity((long) (airHumidity/numberOfDays));
        weather.setAirPressureMB(airPressure/(numberOfDays*24));
        weather.setWindSpeedMH(windSpeed/(numberOfDays*24));

        return weather;
    }
}
