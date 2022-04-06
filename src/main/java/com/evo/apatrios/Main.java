package com.evo.apatrios;

import com.evo.apatrios.model.Instruction;
import com.evo.apatrios.model.Replacement;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("info/replacement.json");
        String api = "https://raw.githubusercontent.com/thewhitesoft/student-2022-assignment/main/data.json";

        //Объявляем собственный класс, выполняющий нашу основную работу с json файлами
        JsonParser jsonHandler= new CustomJsonParser();
        //Список исходных сообщений
        List<String> data = null;
        //Список исправленных сообщений
        List<String> result = new ArrayList<>();
        try {
            data = jsonHandler.readDataFromApiToList(api);
            //Список подмен - то что нужно поменять и на что
            List<Instruction> replacement = jsonHandler.readInstructionFileToList(file);

        /*
        Механизм поиска в исходных сообщениях тех самых измененных фрагментов
        и последующая их замена
        */
        for (int i = 0; i < data.size(); i++) {
            String dataByI = data.get(i);
            for (int j = 0; j < replacement.size(); j++) {
                Replacement repByJ = (Replacement) replacement.get(j);
                if(dataByI.contains(repByJ.getInstruction())){
                    String replace;
                    if(repByJ.getSource()==null){
                        replace=dataByI.replace(repByJ.getInstruction(), "");
                        if(!replace.equals("")) {
                            result.add(replace);
                        }
                        dataByI =null;
                        break;
                    }else {
                        replace= dataByI.replace(repByJ.getInstruction(), repByJ.getSource());
                        result.add(replace);
                        dataByI =null;
                        break;
                    }
                }
            }
            if(dataByI!=null) {
                result.add(dataByI);
            }
        }
        //Создаем файл в который будет записываться результат работы
        File resultFile = new File("info/result.json");
        //Вызываем метод, выполняющий запись списка в файл
        jsonHandler.writeListToJsonFile(result, resultFile);
        } catch (IOException | ParseException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
