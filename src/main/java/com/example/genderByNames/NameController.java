package com.example.genderByNames;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {



    @GetMapping("/genderVariant1")
    public String genderVariant1(@RequestParam(value = "name", defaultValue = "Andrzej") String fullName) throws IOException {

        Name[] name = nameStringToArray(fullName);

        String gender = name[0].gender();

        return gender;
    }

    @GetMapping("/genderVariant2")
    public String genderVariant2(@RequestParam(value = "name", defaultValue = "Andrzej") String fullName) throws IOException {

        Name[] name = nameStringToArray(fullName);

        String gender = dominantGender(name);

                    return gender;
        }

    public Name[] nameStringToArray(String fullName){

        String[] namesArray = fullName.split(" ");

        Name[] name = new Name[namesArray.length];

        for (int i = 0; i < namesArray.length; i++) {
            name[i] = new Name(namesArray[i]);
        }
        return name;
    }
    public String dominantGender(Name[] name) throws IOException {

        String gender = "";
        int male = 0;
        int female = 0;

        for(int i = 0; i < name.length;i++){

            if(name[i].isMale())
                male++;

            else if(name[i].isFemale())
                female++;
        }

        if(male!=female){
            if(male>female)
                return "male";
            else
                return "female";
        }

        return "inconclusive";
    }

}