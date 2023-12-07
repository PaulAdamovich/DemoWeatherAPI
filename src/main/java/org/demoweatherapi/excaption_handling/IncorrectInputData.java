package org.demoweatherapi.excaption_handling;

public class IncorrectInputData extends RuntimeException{
    public IncorrectInputData(String message) {
        super(message);
    }
}
