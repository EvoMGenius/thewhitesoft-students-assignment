package com.evo.apatrios.WSUtils;

import com.evo.apatrios.fileToJsonParserUtils.ParserFileToJsonArray;
import com.evo.apatrios.fileToJsonParserUtils.ParserWSFileToJsonArray;
import com.evo.apatrios.jsonToListConverterUtils.JsonArrayToListConverter;
import com.evo.apatrios.jsonToListConverterUtils.WSJsonArrayToListConverter;
import com.evo.apatrios.model.Instruction;
import com.evo.apatrios.remoteDataUtils.GetterRemoteDataFromApi;
import com.evo.apatrios.remoteDataUtils.GetterWSApiData;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpClient;
import java.util.List;

public class WSInput {
    private final File instruction;
    static private final String API = "https://raw.githubusercontent.com/thewhitesoft/student-2022-assignment/main/data.json";

    private final ParserFileToJsonArray fileToJsonParser;
    private final GetterRemoteDataFromApi jsonFromApi;
    private final JsonArrayToListConverter jsonToListConverter;

    /**
     * @param instruction
     * файл для чтения инструкции replacement.json
     * Сделал специально в конструкторе инициализацию этих полей, ибо сейчас привязка под эту реализацию.
     */
    public WSInput(File instruction) {
        this.instruction = instruction;
        this.fileToJsonParser = new ParserWSFileToJsonArray();
        this.jsonFromApi = new GetterWSApiData(API, HttpClient.newHttpClient());
        this.jsonToListConverter = new WSJsonArrayToListConverter();
    }

    public List<String> inputData() throws ParseException, IOException, InterruptedException {
        return jsonToListConverter.dataJsonArrayToList(jsonFromApi.getDataFromApi());
    }

    public List<Instruction> inputReplacement() throws IOException, ParseException {
        return jsonToListConverter.instructionsJsonArrayToList(fileToJsonParser.getJsonFromFile(instruction));
    }

}
