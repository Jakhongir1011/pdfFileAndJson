package org.example.POJO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();

          File file = new File("src/main/resources/user.json");
          try(BufferedReader reader = new BufferedReader(new FileReader(file))){

              User[] users = gson.fromJson(reader, User[].class);
              System.out.println(users);

              System.out.println("//////////////////");

              String s = gson.toJson(users);
//              System.out.println(s);

          } catch (FileNotFoundException e) {
              throw new RuntimeException(e);
          } catch (IOException e) {
              throw new RuntimeException(e);
          }

    }
}
