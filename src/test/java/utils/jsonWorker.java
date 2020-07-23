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

    public static void writeJson(String firstVacancy, String firstSalary, String secondVacancy, String secondSalary, String totalFound1, String totalFound2) {
        JSONParser jsonParser = new JSONParser();
        String currentDate = String.valueOf(java.time.LocalDate.now());

        try {

            Object obj = jsonParser.parse(new FileReader("src/test/java/resources/vacancy.json"));
            JSONArray jsonArray = (JSONArray) obj;

            JSONObject newVacancy = new JSONObject();
            JSONArray list1 = new JSONArray();
            JSONArray list2 = new JSONArray();
            newVacancy.put("Date:", currentDate);

            list1.add("Total vacancies: " + totalFound1);
            list1.add("Mid Salary: " + firstSalary);

            list2.add("Total vacancies: " + totalFound2);
            list2.add("Mid Salary: " + secondSalary);

            newVacancy.put(firstVacancy, list1);
            newVacancy.put(secondVacancy, list2);


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


