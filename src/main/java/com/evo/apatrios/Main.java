package com.evo.apatrios;

import com.evo.apatrios.WSUtils.WSInput;
import com.evo.apatrios.WSUtils.WSOutput;
import com.evo.apatrios.WSUtils.WSReplacementLogic;
import com.evo.apatrios.fileToJsonParserUtils.ParserFileToJsonArray;
import com.evo.apatrios.fileToJsonParserUtils.ParserWSFileToJsonArray;
import com.evo.apatrios.jsonToListConverterUtils.JsonArrayToListConverter;
import com.evo.apatrios.jsonToListConverterUtils.WSJsonArrayToListConverter;
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

        File result = new File("info/result.json");
        WSOutput output = new WSOutput(new WSReplacementLogic(new WSInput()), result);

        try {
            output.writeResultListToFile();
        } catch (IOException | ParseException | InterruptedException e) {
            e.printStackTrace();
        }























//        //Объявляем собственный класс, выполняющий нашу основную работу с json файлами
//        JsonArrayToListConverter jsonHandler= new WSJsonArrayToListConverter();
//        //Список исходных сообщений
//        List<String> data = null;
//        //Список исправленных сообщений
//        List<String> result = new ArrayList<>();
//
//        String api = "https://raw.githubusercontent.com/thewhitesoft/student-2022-assignment/main/data.json";
//        GetterRemoteDataFromApi getterDataFromApi = new GetterWSApiData(api);
//
//        ParserFileToJsonArray fileParser = new ParserWSFileToJsonArray();
//
//        try {
//            data = jsonHandler.dataJsonArrayToList(getterDataFromApi.getDataFromApi());
//            //Список подмен - то что нужно поменять и на что
//            File instruction = new File("info/replacement.json");
//            List<Instruction> replacement = jsonHandler.instructionsJsonArrayToList(fileParser.getJsonFromFile(instruction));
//
//        /*
//        Механизм поиска в исходных сообщениях тех самых измененных фрагментов
//        и последующая их замена
//        */
//        for (int i = 0; i < data.size(); i++) {
//            String dataByI = data.get(i);
//            for (int j = 0; j < replacement.size(); j++) {
//                Replacement repByJ = (Replacement) replacement.get(j);
////                if(dataByI.contains(repByJ.getInstruction())){
////                    String replace;
////                    if(repByJ.getSource()==null){
////                        replace=dataByI.replace(repByJ.getInstruction(), "");
////                        if(!replace.equals("")) {
////                            result.add(replace);
////                        }
////                        dataByI =null;
////                        break;
////                    }else {
////                        replace= dataByI.replace(repByJ.getInstruction(), repByJ.getSource());
////                        result.add(replace);
////                        dataByI =null;
////                        break;
////                    }
////                }
//            }
//            if(dataByI!=null) {
//                result.add(dataByI);
//            }
//        }
//        //Создаем файл в который будет записываться результат работы
//        File resultFile = new File("info/result.json");
//        //Вызываем метод, выполняющий запись списка в файл
//        fileParser.JsonToFile(jsonHandler.listToJsonArray(result), resultFile);
//        } catch (IOException | ParseException | InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
