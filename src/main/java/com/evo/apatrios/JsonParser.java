package com.evo.apatrios;

import com.evo.apatrios.model.Instruction;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface JsonParser {
    List<Instruction> readInstructionFileToList(File file) throws IOException, ParseException;
    List<String> readDataFromApiToList(String api) throws IOException, ParseException, InterruptedException;
    void writeListToJsonFile(List<String> data, File file) throws IOException;
}
