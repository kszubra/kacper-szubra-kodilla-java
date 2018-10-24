package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public void readFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
        System.out.println(file.getPath());
        Path path = Paths.get(file.getPath());
        try{

            Stream<String> fileLines = Files.lines(path);
            fileLines.forEach(System.out::println);

        } catch(IOException e){
            System.out.println("\r\nException: " + e.toString());
        }



    }

}
