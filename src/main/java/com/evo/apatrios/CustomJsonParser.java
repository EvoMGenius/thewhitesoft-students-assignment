package com.evo.apatrios;

import com.evo.apatrios.model.Instruction;
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

public class CustomJsonParser implements JsonParser{

    /**
     * The result of this method is {@code List}, which contains all messages from Data.json
     * @return List
     */
    @Override
    public List<String> readDataFromApiToList(String api) throws IOException, ParseException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(api))
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
    @Override
    public List<Instruction> readInstructionFileToList(File file) throws IOException, ParseException {
        FileReader fr = new FileReader(file);
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse(fr);
        List<Instruction> list = new ArrayList<>();
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
    @Override
    public void writeListToJsonFile(List<String> data, File file)throws IOException {
        JSONArray resultArray = new JSONArray();
        resultArray.addAll(data);
        FileWriter writer = new FileWriter(file);
        if(file.exists()){
            file.createNewFile();
        }
        resultArray.writeJSONString(writer);
        writer.flush();
        writer.close();
    }
}
