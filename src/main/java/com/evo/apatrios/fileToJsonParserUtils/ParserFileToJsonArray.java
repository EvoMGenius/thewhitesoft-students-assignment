package com.evo.apatrios.fileToJsonParserUtils;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public interface ParserFileToJsonArray {
    JSONArray getJsonFromFile(File file) throws IOException, ParseException;
    void JsonToFile(JSONArray json, File file) throws IOException;
}
