package org.demoweatherapi.excaption_hadling;

public class IncorrectInputData extends RuntimeException{
    public IncorrectInputData(String message) {
        super(message);
    }
}
