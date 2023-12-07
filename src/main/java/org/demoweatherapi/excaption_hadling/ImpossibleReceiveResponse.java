package org.demoweatherapi.excaption_hadling;

public class ImpossibleReceiveResponse extends RuntimeException {
    public ImpossibleReceiveResponse(String message) {
        super(message);
    }
}
