package com.evo.apatrios.jsonToListConvertUtils;

import com.evo.apatrios.model.Instruction;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface JsonArrayToListConverter {
    List<Instruction> instructionsJsonArrayToList(JSONArray json) throws IOException, ParseException;
    List<String> dataJsonArrayToList(JSONArray json) throws IOException, ParseException, InterruptedException;
    JSONArray listToJsonArray(List<String> data) throws IOException;
}
