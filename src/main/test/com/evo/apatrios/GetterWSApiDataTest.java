package com.evo.apatrios;

import com.evo.apatrios.remoteDataUtils.GetterRemoteDataFromApi;
import com.evo.apatrios.remoteDataUtils.GetterWSApiData;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;

public class GetterWSApiDataTest {
    @Test
    void testApiCurrentData() throws ParseException, IOException, InterruptedException {
        //Arrange
        GetterRemoteDataFromApi getter = new GetterWSApiData("https://raw.githubusercontent.com/thewhitesoft/student-2022-assignment/main/data.json");

        //Act
        JSONArray data = getter.getDataFromApi();
        //Assert
        ;
    }
}
