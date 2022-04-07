package com.evo.apatrios.remoteDataUtils;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface GetterRemoteDataFromApi {
    JSONArray getDataFromApi() throws ParseException, IOException, InterruptedException;
}
