package org.demoweatherapi.communicate_third_API;

import org.demoweatherapi.excaption_handling.ImpossibleReceiveResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class Communicate {
    public String getWeatherRealTime() {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=Minsk"))
                .header("X-RapidAPI-Key", "703e6c5d3bmshd82d36cf0965eecp1dd216jsn572ff850ea1a")
                .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new ImpossibleReceiveResponse(e.getMessage());
        }
        return response.body();
    }

    public String getAverageWeather(String from, String to)  {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://weatherapi-com.p.rapidapi.com/history.json?q=Minsk&dt="+from+"&lang=en&end_dt="+to))
                .header("X-RapidAPI-Key", "703e6c5d3bmshd82d36cf0965eecp1dd216jsn572ff850ea1a")
                .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new ImpossibleReceiveResponse(e.getMessage());
        }
        return response.body();
    }
}
