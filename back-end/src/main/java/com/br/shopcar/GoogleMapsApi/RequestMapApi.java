package com.br.shopcar.GoogleMapsApi;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Component
public class RequestMapApi {

    private static final String API_KEY="AIzaSyCUjaBfyXWqm_lljkdY4cBuJdYV3Sk9EQA";

    public static String getUrl(String origin, String destination){
        String URL_GET = "https://maps.googleapis.com/maps/api/distancematrix/json?" +
                "origins=" + origin +
                "&destinations=" + destination +
                "&key=" + API_KEY;
        return URL_GET;
    }

    public static String encode(String stringToEncode){
        String str = stringToEncode.replaceAll(" ", "%20");
        return str.replaceAll("," , "%2C");
    }

    public static String calculateDistance(String origin, String destination) {
        String originEnconde = encode(origin);
        String destinationEncode = encode(destination);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(getUrl(originEnconde,destinationEncode)))
                .build();

        HttpResponse<String> response;
        {
            try {
                response = client.send(request,HttpResponse.BodyHandlers.ofString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return response.body();
        }
    }
}



