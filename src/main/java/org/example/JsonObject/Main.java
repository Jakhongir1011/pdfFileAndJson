package org.example.JsonObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
public class Main {
    public static void main(String[] args) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        File file = new File("src/main/resources/jsonObject.json");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

                JsonObject jsonObject = gson.fromJson(reader,JsonObject.class);
            System.out.println(jsonObject);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
