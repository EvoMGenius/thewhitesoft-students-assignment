package com.evo.apatrios.tests;

import com.evo.apatrios.fileToJsonParserUtils.ParserFileToJsonArray;
import com.evo.apatrios.fileToJsonParserUtils.ParserWSFileToJsonArray;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpResponse;

public class GetterWSApiDataTest {
    @Test
    public void testCurrencyOfDataFromApi() throws ParseException, IOException{
        //Arrange
        HttpResponse response = Mockito.mock(HttpResponse.class);
        //не знаю стоит ли мне делать mock httpClient, если да, то тогда бы пришлось в HttpRequest мокать
        Mockito.when(response.body()).thenReturn("[\n" +
                "  \"Two roads diverged in a yellow d12324344rgg6f5g6gdf2ddjf,\",\n" +
                "  \"Robert Frost poetAnd sorry I cou1d not trave1 both\",\n" +
                "  \"An other text\",\n" +
                "  \"And be one trave1er, long I stood\",\n" +
                "  \"And 1ooked down one as far as I cou1d\",\n" +
                "  \"Bla-bla-bla-blaaa, just some RANDOM tExT\",\n" +
                "  \"To where it bent in the undergrowth;\",\n" +
                "  \"Then Random text, yeeep the other, as just as fair,\",\n" +
                "  \"And having perhaps parentheses - that is a smart word,\",\n" +
                "  \"Bla-bla-bla-blaaa, just some RANDOM tExT\",\n" +
                "  \"Because it was grassy and wanted wear;\",\n" +
                "  \"An other text\",\n" +
                "  \"An other text\",\n" +
                "  \"Though as for that the passing there\",\n" +
                "  \"Emptry... or NOT! them rea11y about the same,\",\n" +
                "  \"And both that morning equally lay\",\n" +
                "  \"In 1eaves no step had trodden b1ack.\",\n" +
                "  \"Oh, I kept the first for another day!\",\n" +
                "  \"Yet Skooby-dooby-doooo 1eads on to way,\",\n" +
                "  \"Ha-haaa, hacked you.\",\n" +
                "  \"An other text\",\n" +
                "  \"I shall be te11ing this with a sigh\",\n" +
                "  \"sdshdjdskfm sfjsdif jfjfidjf\",\n" +
                "  \"Two roads diverged in a d12324344rgg6f5g6gdf2ddjf, and I\",\n" +
                "  \"I Random text, yeeep the one less traveled by,\",\n" +
                "  \"And that has made a11 the difference.\",\n" +
                "  \"Bla-bla-bla-blaaa, just some RANDOM tExT\"\n" +
                "]");
        ParserFileToJsonArray parserFiles = new ParserWSFileToJsonArray();

        JSONParser parserJson = new JSONParser();
        //Act
        JSONArray jsonFromFile = parserFiles.getJsonFromFile(new File("info/data.json"));

        JSONArray jsonFromApi = (JSONArray) parserJson.parse (response.body().toString());
        //Assert

        Assert.assertEquals(jsonFromFile, jsonFromApi);
    }
}
