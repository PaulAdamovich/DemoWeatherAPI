package org.demoweatherapi.excaption_hadling;

public class ImpossibleParseResponse extends RuntimeException{
    public ImpossibleParseResponse(String message) {
        super(message);
    }
}
