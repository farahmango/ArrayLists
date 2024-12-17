package org.example;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        FileReader fileReader;
        try {
            File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\countries_array.json");
            fileReader = new FileReader(file);
            ArrayList<String> allCountries;
            ArrayList<String> islands = new ArrayList<>();
            allCountries = (ArrayList<String>) parser.parse(fileReader);

            System.out.println(allCountries.size());
            for (String country : allCountries) {
                System.out.println(country);
                if (country.contains(" and ") && country.startsWith("S")){
                    System.out.println(country.replaceAll("Saint","Jordan"));
                }
                if (country.contains(" Islands ")){
                    islands.add(country);
                }
            }
            System.out.println(islands.size());
            for (String island : islands){
                System.out.println(island);
            }


        } catch (FileNotFoundException e) {
            System.out.println(e.getStackTrace() + " :File Not Found");
        } catch (ParseException e) {
            System.out.println(e.getStackTrace() + " :Could not parse");
        } catch (IOException e) {
            System.out.println(e.getStackTrace() + " :IOException");
        }
    }
}
