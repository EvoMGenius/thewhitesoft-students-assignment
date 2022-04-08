package com.evo.apatrios.remoteDataUtils;

import com.evo.apatrios.remoteDataUtils.GetterRemoteDataFromApi;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetterWSApiData implements GetterRemoteDataFromApi {

    private final String API = "https://raw.githubusercontent.com/thewhitesoft/student-2022-assignment/main/data.json";
    private final HttpClient client;

    public String getApi() {
        return API;
    }

    public GetterWSApiData( HttpClient httpClient) {
        this.client = httpClient;
    }

    @Override
    public JSONArray getDataFromApi() throws ParseException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(API))
                .build();
        HttpResponse<String> data = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONParser parser = new JSONParser();
        return (JSONArray) parser.parse(data.body());
    }
}
