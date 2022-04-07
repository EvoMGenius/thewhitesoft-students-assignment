package com.evo.apatrios;

import com.evo.apatrios.model.Instruction;
import com.evo.apatrios.model.Replacement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;

public class WSJsonArrayToListConverter implements JsonArrayToListConverter {

    /**
     * The result of this method is {@code List}, which contains all messages from Data.json
     * @return List
     */
    @Override
    public List<String> dataJsonArrayToList(JSONArray json) throws IOException, ParseException, InterruptedException {
        return new ArrayList<String>(json);
    }
    /**
     * The result of this method is {@code List}, which contains all objects from Replacement.json in reverse order
     * @return List
    */
    @Override
    public List<Instruction> instructionsJsonArrayToList(JSONArray json) throws IOException, ParseException {
        List<Instruction> list = new ArrayList<>();
        Iterator i = json.iterator();
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
    public JSONArray listToJsonArray(List<String> data)throws IOException {
        JSONArray resultArray = new JSONArray();
        resultArray.addAll(data);
        return resultArray;
    }
}
