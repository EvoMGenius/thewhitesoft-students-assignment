package com.evo.apatrios.tests;

import com.evo.apatrios.fileToJsonParserUtils.ParserFileToJsonArray;
import com.evo.apatrios.fileToJsonParserUtils.ParserWSFileToJsonArray;
import org.json.simple.JSONArray;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class ParserFileToJsonArrayTest {
    @Test
    public void noFileTest(){
        //arrange
        //files correct path is "info/"

        ParserFileToJsonArray parser = new ParserWSFileToJsonArray();
        File file = new File("not/info/file.json");
        //act
        //assert
        Assert.assertThrows(FileNotFoundException.class, ()-> {
           JSONArray json = parser.getJsonFromFile(file);
        });
    }
}
