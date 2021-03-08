package com.example.genderByNames;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Name {


    private final String name;
    final String maleNamesFileName = "static/namesMale.csv";
    final String femaleNamesFileName = "static/namesFemale.csv";

    public Name(String name) {

        String temp = name.toLowerCase();
        this.name  = temp.substring(0, 1).toUpperCase() + temp.substring(1);

    }


    public String getName() {
        return name;
    }

    private InputStream getFileFromResourceAsStream(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if(inputStream == null){
            throw new IllegalArgumentException("file "+ fileName + " not found!");
        }
        else{
            return inputStream;
        }
    }

    private boolean nameFoundInFile(InputStream is){

        try(InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader)){

            String line;
            do{
                if((line = reader.readLine()) == null){
                    return false;
                }
            } while (!line.equals(this.name));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean isMale() {

        InputStream maleFileStream = getFileFromResourceAsStream(maleNamesFileName);

        return nameFoundInFile(maleFileStream);
    }

    public boolean isFemale() {

        InputStream femaleFileStream = getFileFromResourceAsStream(femaleNamesFileName);

        return nameFoundInFile(femaleFileStream);
    }
    public String gender() throws IOException {

        if(isMale())
            return "male";

        else if(isFemale())
            return "female";

        return "inconclusive";
    }
}