package com.evo.apatrios.WSUtils;

import com.evo.apatrios.model.Instruction;
import com.evo.apatrios.model.Replacement;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WSReplacementLogic {
    private WSInput input;

    public WSReplacementLogic() {
    }

    public List<String> replacementLogic() throws ParseException, IOException, InterruptedException {
        List<String> result = new ArrayList<>();
        List<String> data = input.inputData();
        List<Instruction> replacement = input.inputReplacement();
        for (String dataByI : data) {
            for (Instruction instruction : replacement) {
                Replacement repByJ = (Replacement) instruction;
                if (dataByI.contains(repByJ.getInstruction())) {
                    String replace;
                    if (repByJ.getSource() == null) {
                        replace = dataByI.replace(repByJ.getInstruction(), "");
                        if (!replace.equals("")) {
                            result.add(replace);
                        }
                        dataByI = null;
                        break;
                    } else {
                        replace = dataByI.replace(repByJ.getInstruction(), repByJ.getSource());
                        result.add(replace);
                        dataByI = null;
                        break;
                    }
                }
            }
            if (dataByI != null) {
                result.add(dataByI);
            }
        }
        return result;
    }

    public WSInput getInput() {
        return input;
    }

    public void setInput(WSInput input) {
        this.input = input;
    }

}
