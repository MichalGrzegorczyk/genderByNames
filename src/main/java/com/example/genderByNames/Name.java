package com.example.genderByNames;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Name {


    private final String name;
    final String pathToMaleNames = "./src/main/resources/static/namesMale.csv";
    final String pathToFemaleNames = "./src/main/resources/static/namesFemale.csv";

    public Name(String name) {

        name = name.toLowerCase();
        this.name  = name.substring(0, 1).toUpperCase() + name.substring(1);

    }


    public String getName() {
        return name;
    }

    public boolean isMale() throws IOException {
        BufferedReader maleNamesReader = new BufferedReader(new FileReader(pathToMaleNames));

        String line;
        do {
            if ((line = maleNamesReader.readLine()) == null) {
                return false;
            }
        } while (!line.equals(this.name));

        return true;
    }

    public boolean isFemale() throws IOException {
        BufferedReader femaleNamesReader = new BufferedReader(new FileReader(pathToFemaleNames));

        String line;
        do {

            if ((line = femaleNamesReader.readLine()) == null) {
                return false;
            }

        } while (!line.equals(this.name));

        return true;
    }
    public String gender() throws IOException {

        if(isMale())
            return "male";

        else if(isFemale())
            return "female";

        return "inconclusive";
    }
}