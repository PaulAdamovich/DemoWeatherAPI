package org.demoweatherapi.excaption_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WeatherGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<WeatherIncorrectData> handlingException(IncorrectInputData exception){
        WeatherIncorrectData data = new WeatherIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<WeatherIncorrectData> handlingException(ImpossibleReceiveResponse exception){
        WeatherIncorrectData data = new WeatherIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler
    public ResponseEntity<WeatherIncorrectData> handlingException(ImpossibleParseResponse exception){
        WeatherIncorrectData data = new WeatherIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_IMPLEMENTED);
    }

}
