package com.evo.apatrios;

import com.evo.apatrios.model.Replacement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class CustomJsonParser {

    public static final String API_URL = "https://raw.githubusercontent.com/thewhitesoft/student-2022-assignment/main/data.json";

    /**
     * The result of this method is {@code List}, which contains all messages from Data.json
     * @return List
     */
    public List<String> readDataJson() throws IOException, ParseException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(API_URL))
                .build();
        HttpResponse<String> data = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse(data.body());
        return new ArrayList<String>(array);
    }
    /**
     * The result of this method is {@code List}, which contains all objects from Replacement.json in reverse order
     * @return List
    */
    public List<Replacement> readReplacementJson() throws IOException, ParseException {
        File file = new File("info/replacement.json");
        FileReader fr = new FileReader(file);
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse(fr);
        List<Replacement> list = new ArrayList<>();
        Iterator i = array.iterator();
        while (i.hasNext()){
            JSONObject object = (JSONObject) i.next();
            Object replacementObj = object.get("replacement");
            Object sourceObj = object.get("source");
            String source=null;
            if(sourceObj!=null){
                source=sourceObj.toString();
            }
            String replacement = replacementObj.toString();
            list.add(0,new Replacement(replacement,source));
        }
        return list;
    }
    /**
     * This method writes the received list to the received file
     */
    public void writeListToJsonAndToFile(File resultFile, List<String> data) throws IOException {
        JSONArray resultArray = new JSONArray();
        resultArray.addAll(data);
        FileWriter writer = new FileWriter(resultFile);
        if(resultFile.exists()){
            resultFile.createNewFile();
        }
        resultArray.writeJSONString(writer);
        writer.flush();
        writer.close();
    }
}
