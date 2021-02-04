package com.barabieres.item;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class JsonBeerRepository implements BeerRepository {
    String path;

    public JsonBeerRepository(String path) {
        this.path = path;
    }

    @Override
    public List<Beer> getAllBeers() {
        JSONParser jsonParser = new JSONParser();

        List<Beer> allBeers = null;

        try (FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);
            JSONArray beers = (JSONArray) obj;

            allBeers = (List<Beer>) beers.stream().map(beer -> parseBeer((JSONObject) beer)).collect(toList());
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return allBeers;
    }

    private Beer parseBeer(JSONObject beer) {
        return new Beer((String) beer.get("name"), (double) beer.get("price"), (double) beer.get("abv"));
    }
}
