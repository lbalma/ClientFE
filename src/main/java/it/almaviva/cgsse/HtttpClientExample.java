package it.almaviva.cgsse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HtttpClientExample {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();


    public static void main(String[] args) throws IOException, InterruptedException {


        String u = "http://localhost:80/protocgsse/jsonapi/taxonomy_term/azienda";


        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(u))
                .setHeader("Accept", "application/vnd.api+json")
                .setHeader("Content-type", "application/vnd.api+json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());

    }

}
