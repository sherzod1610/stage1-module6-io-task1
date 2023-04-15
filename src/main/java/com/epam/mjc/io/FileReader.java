package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file){
        FileReader fileReader = new FileReader();
        Profile profile = null;
        String[] array;
        try {
            array = fileReader.getInformation(fileReader.readFile(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        profile.setName(array[0].split(" ")[1]);
        profile.setAge(Integer.valueOf(array[3].split(" ")[1]));
        profile.setEmail(array[5].split(" ")[1]);
        profile.setPhone(Long.valueOf(array[7].split(" ")[1]));
        return profile;
    }

    public String readFile(File file) throws FileNotFoundException {
        String a = "";

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int ch;
            while ((ch = fileInputStream.read()) != -1){
                a += (char)ch;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return a;
    }


    public String[] getInformation(String text){

        return text.split("\n");
    }
}
