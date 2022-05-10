package com.evo.apatrios.WSUtils;

import com.evo.apatrios.fileToJsonParserUtils.ParserFileToJsonArray;
import com.evo.apatrios.fileToJsonParserUtils.ParserWSFileToJsonArray;
import com.evo.apatrios.jsonToListConvertUtils.JsonArrayToListConverter;
import com.evo.apatrios.jsonToListConvertUtils.WSJsonArrayToListConverter;
import com.evo.apatrios.model.Instruction;
import com.evo.apatrios.remoteDataUtils.GetterRemoteDataFromApi;
import com.evo.apatrios.remoteDataUtils.GetterWSApiData;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpClient;
import java.util.List;

/**
 * Вся завязка на WS специально!
 */
public class WSInput {
    private final File instruction;

    private final ParserFileToJsonArray fileToJsonParser = new ParserWSFileToJsonArray();
    private final GetterRemoteDataFromApi jsonFromApi;
    private final JsonArrayToListConverter jsonToListConverter = new WSJsonArrayToListConverter();

    public WSInput() {
        this.jsonFromApi = new GetterWSApiData(HttpClient.newHttpClient());
        this.instruction = this.fileToJsonParser.getInstruction();

    }

    public List<String> inputData() throws ParseException, IOException, InterruptedException {
        return jsonToListConverter.dataJsonArrayToList(jsonFromApi.getDataFromApi());
    }

    public List<Instruction> inputReplacement() throws IOException, ParseException {
        return jsonToListConverter.instructionsJsonArrayToList(fileToJsonParser.getJsonFromFile(instruction));
    }
}
