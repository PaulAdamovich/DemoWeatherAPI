package org.demoweatherapi.excaption_handling;

public class ImpossibleParseResponse extends RuntimeException{
    public ImpossibleParseResponse(String message) {
        super(message);
    }
}
