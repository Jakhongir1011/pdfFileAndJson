package org.example.Gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class GsonLesson {
    public static void main(String[] args) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        File file = new File("src/main/resources/album.json");

        try( BufferedReader reader = new BufferedReader(new FileReader(file))) {

//            String line;
//                while ((line=reader.readLine())!=null){
//                    System.out.println(line);
//                }

            Album album = gson.fromJson(reader,Album.class);
            System.out.println(album);

            String jsonAlbum = gson.toJson(album);
            System.out.println(jsonAlbum);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
