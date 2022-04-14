package com.evo.apatrios.WSUtils;

import com.evo.apatrios.fileToJsonParserUtils.ParserFileToJsonArray;
import com.evo.apatrios.fileToJsonParserUtils.ParserWSFileToJsonArray;
import com.evo.apatrios.jsonToListConverterUtils.JsonArrayToListConverter;
import com.evo.apatrios.jsonToListConverterUtils.WSJsonArrayToListConverter;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class WSOutput {
    private WSReplacementLogic logic;
    private final JsonArrayToListConverter jsonListConverter;
    private final ParserFileToJsonArray fileJsonConverter;
    private final File resultFile;

    public WSReplacementLogic getLogic() {
        return logic;
    }

    public void setLogic(WSReplacementLogic logic) {
        this.logic = logic;
    }

    public WSOutput(File resultFile) {
        this.fileJsonConverter = new ParserWSFileToJsonArray();
        this.jsonListConverter = new WSJsonArrayToListConverter();
        this.resultFile = resultFile;
    }

    public JsonArrayToListConverter getJsonListConverter() {
        return jsonListConverter;
    }

    public ParserFileToJsonArray getFileJsonConverter() {
        return fileJsonConverter;
    }

    public void writeResultListToFile() throws IOException, ParseException, InterruptedException {
        fileJsonConverter.JsonToFile(jsonListConverter.listToJsonArray(logic.replacementLogic()),resultFile);
    }

}
