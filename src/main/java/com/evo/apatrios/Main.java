package com.evo.apatrios;

import com.evo.apatrios.WSUtils.WSInput;
import com.evo.apatrios.WSUtils.WSOutput;
import com.evo.apatrios.WSUtils.WSReplacementLogic;
import com.evo.apatrios.fileToJsonParserUtils.ParserFileToJsonArray;
import com.evo.apatrios.fileToJsonParserUtils.ParserWSFileToJsonArray;
import com.evo.apatrios.model.Instruction;
import com.evo.apatrios.model.Replacement;
import com.evo.apatrios.remoteDataUtils.GetterRemoteDataFromApi;
import com.evo.apatrios.remoteDataUtils.GetterWSApiData;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        File instruction = new File("info/replacement.json");
        File result = new File("info/result.json");

        WSInput input = new WSInput();
        WSReplacementLogic logic = new WSReplacementLogic();
        logic.setInput(input);
        WSOutput output = new WSOutput(result);
        output.setLogic(logic);

        try {
            output.writeResultListToFile();
        } catch (IOException | ParseException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
