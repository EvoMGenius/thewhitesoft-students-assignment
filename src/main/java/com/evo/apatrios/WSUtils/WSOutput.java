package com.evo.apatrios.WSUtils;

import com.evo.apatrios.fileToJsonParserUtils.ParserFileToJsonArray;
import com.evo.apatrios.fileToJsonParserUtils.ParserWSFileToJsonArray;
import com.evo.apatrios.jsonToListConvertUtils.JsonArrayToListConverter;
import com.evo.apatrios.jsonToListConvertUtils.WSJsonArrayToListConverter;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

/**
 * Вся завязка на WS специально!
 */
public class WSOutput {

    private WSReplacementLogic logic;
    private final JsonArrayToListConverter jsonListConverter = new WSJsonArrayToListConverter();
    private final ParserFileToJsonArray fileJsonConverter = new ParserWSFileToJsonArray();

    private final File resultFile;

    public WSOutput (File resultFile) {
        this.resultFile = resultFile;
    }

    public WSReplacementLogic getLogic() {
        return logic;
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

    public void setLogic(WSReplacementLogic logic) {
        this.logic = logic;
    }
}
