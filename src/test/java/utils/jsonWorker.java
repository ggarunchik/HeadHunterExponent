package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class jsonWorker {

    public static void writeJson(String firstVacancy, String firstSalary, String secondVacancy, String secondSalary) {
        JSONParser jsonParser = new JSONParser();
        String currentDate = String.valueOf(java.time.LocalDate.now());

        try {

            Object obj = jsonParser.parse(new FileReader("src/test/java/resources/vacancy.json"));
            JSONArray jsonArray = (JSONArray) obj;

            JSONObject newVacancy = new JSONObject();
            newVacancy.put("Date:", currentDate);
            newVacancy.put(firstVacancy, new Integer(firstSalary));
            newVacancy.put(secondVacancy, new Integer(secondSalary));
            newVacancy.put(secondVacancy, new Integer(secondSalary));

            jsonArray.add(newVacancy);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(jsonArray.toString());
            String prettyJsonString = gson.toJson(je);

            System.out.println(prettyJsonString);

            FileWriter file = new FileWriter("src/test/java/resources/vacancy.json");
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


}


