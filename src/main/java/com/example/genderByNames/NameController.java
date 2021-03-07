package com.example.genderByNames;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {



    @GetMapping("/gender")
    public String gender(@RequestParam(value = "name", defaultValue = "Andrzej") String fullName) throws IOException {

        String gender = "";

        String[] namesArray = fullName.split(" ");

        Name[] name = new Name[namesArray.length];

        for (int i = 0;i<namesArray.length;i++) {
            name[i] = new Name(namesArray[i]);
        }

        gender = name[0].gender();

        return  gender;
    }
}