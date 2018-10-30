package com.kodilla.rps.handler;

import javax.xml.stream.events.Characters;
import java.util.Arrays;
import java.util.List;

public class IfNumber {

    public static boolean isItInteger(String stringToCheck){

        char[] characters = stringToCheck.toCharArray();
        for(char i : characters){

            if(!Character.isDigit(i)){
                return false;
            }
        }
        return true;
    }

}



