package com.evo.apatrios;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ParserWSFileToJsonArray implements ParserFileToJsonArray{
    @Override
    public JSONArray getJsonFromFile(File file) throws IOException, ParseException {
        FileReader fr = new FileReader(file);
        JSONParser parser = new JSONParser();
        return (JSONArray) parser.parse(fr);
    }

    @Override
    public void JsonToFile(JSONArray json, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        if(file.exists()){
            file.createNewFile();
        }
        json.writeJSONString(writer);
        writer.flush();
        writer.close();
    }
}
