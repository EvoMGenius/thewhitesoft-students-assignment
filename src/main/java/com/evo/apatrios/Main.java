package com.evo.apatrios;

import com.evo.apatrios.WSUtils.WSInput;
import com.evo.apatrios.WSUtils.WSOutput;
import com.evo.apatrios.WSUtils.WSReplacementLogic;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

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
