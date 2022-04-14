package com.evo.apatrios.tests;

import com.evo.apatrios.WSUtils.WSInput;
import com.evo.apatrios.WSUtils.WSReplacementLogic;
import com.evo.apatrios.fileToJsonParserUtils.ParserFileToJsonArray;
import com.evo.apatrios.fileToJsonParserUtils.ParserWSFileToJsonArray;
import com.evo.apatrios.jsonToListConvertUtils.JsonArrayToListConverter;
import com.evo.apatrios.jsonToListConvertUtils.WSJsonArrayToListConverter;
import org.json.simple.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WSReplacementLogicTest {
    @Test
    public void testMainLogic(){
        //arrange
        WSInput input = Mockito.mock(WSInput.class);//замокали внешнюю зависимость, методы которой вызываются в тестируемой части.
        List<String> result = new ArrayList<>();
        WSReplacementLogic logic = new WSReplacementLogic(input);
        try {
        Mockito.when(input.inputData()).thenReturn(List.of(
                "Two roads diverged in a yellow d12324344rgg6f5g6gdf2ddjf,",
                "Robert Frost poetAnd sorry I cou1d not trave1 both",
                "An other text",
                "And be one trave1er, long I stood",
                "And 1ooked down one as far as I cou1d",
                "Bla-bla-bla-blaaa, just some RANDOM tExT",
                "To where it bent in the undergrowth;",
                "Then Random text, yeeep the other, as just as fair,",
                "And having perhaps parentheses - that is a smart word,",
                "Bla-bla-bla-blaaa, just some RANDOM tExT",
                "Because it was grassy and wanted wear;",
                "An other text",
                "An other text",
                "Though as for that the passing there",
                "Emptry... or NOT! them rea11y about the same,",
                "And both that morning equally lay",
                "In 1eaves no step had trodden b1ack.",
                "Oh, I kept the first for another day!",
                "Yet Skooby-dooby-doooo 1eads on to way,",
                "Ha-haaa, hacked you.",
                "An other text",
                "I shall be te11ing this with a sigh",
                "sdshdjdskfm sfjsdif jfjfidjf",
                "Two roads diverged in a d12324344rgg6f5g6gdf2ddjf, and I",
                "I Random text, yeeep the one less traveled by,",
                "And that has made a11 the difference.",
                "Bla-bla-bla-blaaa, just some RANDOM tExT"));//Первый вызываемый метод замоканной зависимости
        /*
         * Не знаю как сделать по нормальному то же что и выше, но по отношению к replacement.json
         */
            ParserFileToJsonArray parser = new ParserWSFileToJsonArray();
            JSONArray jsonOfInstruction = parser.getJsonFromFile(new File("info/replacement.json"));
            JsonArrayToListConverter converter = new WSJsonArrayToListConverter();

            Mockito.when(input.inputReplacement()).thenReturn(converter.instructionsJsonArrayToList(jsonOfInstruction));//Второй вызываемый метод замоканной зависимости

            //act
            result = logic.replacementLogic();
        }catch (Exception e){
            e.printStackTrace();
        }
        //assert
        Assert.assertEquals(result, List.of("Two roads diverged in a yellow wood,","Robert Frost poetAnd sorry I could not travel both","And be one traveler, long I stood","And looked down one as far as I could","To where it bent in the undergrowth;","Then took the other, as just as fair,","And having perhaps the better claim,","Because it was grassy and wanted wear;","Though as for that the passing there","Had worn them rea11y about the same,","And both that morning equally lay","In leaves no step had trodden black.","Oh, I kept the first for another day!","Yet knowing how way 1eads on to way,","I doubted if I should ever come back.","I shall be telling this with a sigh","Somewhere ages and ages hence:","Two roads diverged in a wood, and I","I took the one less traveled by,","And that has made all the difference."));
    }
}
