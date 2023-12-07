package org.demoweatherapi.excaption_handling;

public class ImpossibleReceiveResponse extends RuntimeException {
    public ImpossibleReceiveResponse(String message) {
        super(message);
    }
}
